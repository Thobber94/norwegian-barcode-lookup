package net.bergby.norwegianbarcodelookupapi.mapper

import net.bergby.norwegianbarcodelookupapi.model.Product
import org.json.JSONObject

fun JSONObject.toProduct() = jsonToProduct(this)

private fun jsonToProduct(jsonObject: JSONObject) : Product {
    val product: JSONObject = jsonObject
                    .getJSONObject("products")
                    .getJSONArray("hits")
                    .getJSONObject(0)
    val productDetails: JSONObject = product.getJSONObject("contentData").getJSONObject("_source")
    return Product(
            barcode = productDetails.getString("ean"),
            name = product.getString("title"),
            price = productDetails.getDouble("pricePerUnit"),
            size = productDetails.getDouble("weight").toString()
    )
}