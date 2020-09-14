package net.bergby.norwegianbarcodelookupapi.service

import net.bergby.norwegianbarcodelookupapi.mapper.toProduct
import net.bergby.norwegianbarcodelookupapi.model.Product
import net.bergby.norwegianbarcodelookupapi.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(
        val productRepository: ProductRepository
) : ProductService {
    override fun getProduct(barcode: String): Product {
        val productFromDatabase = productRepository.findProductByBarcode(barcode)
        return if (productFromDatabase != null) {
            productRepository.save(productFromDatabase)
        } else {
            val xCsrfToken = khttp.get("http://meny.no/").cookies.getCookie("_app_token_")?.value.toString()
            val productResponse = khttp.get(
                    "https://platform-rest-prod.ngdata.no/api/episearch/1300/autosuggest?search=$barcode",
                    headers = mapOf("x-csrf-token" to xCsrfToken)
            )
            productRepository.save(productResponse.jsonObject.toProduct())
        }
    }
}