package net.bergby.norwegianbarcodelookupapi.client

import com.github.kittinunf.fuel.httpGet
import net.bergby.norwegianbarcodelookupapi.model.Product
import net.bergby.norwegianbarcodelookupapi.model.Product.ProductDeserializer
import org.springframework.stereotype.Service

@Service
class MenyClient {
    fun callMenyApiWithBarcode(barcode: String): Product {
        val (_, _, result) = "https://api.ngdata.no/sylinder/search/productsearch/v1/search/7080001150488/products"
            .httpGet(
                listOf(
                    "search" to barcode,
                    "chainId" to "1300"
                )
            ).responseObject(ProductDeserializer())
        return result.component1()!!
    }
}