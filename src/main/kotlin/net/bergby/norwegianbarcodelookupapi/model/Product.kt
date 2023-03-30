package net.bergby.norwegianbarcodelookupapi.model

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

data class Product(
    val total: Int?,
    val hits: List<Hit> = listOf()
) {
    class ProductDeserializer : ResponseDeserializable<Product> {
        override fun deserialize(content: String): Product = Gson().fromJson(content, Product::class.java)
    }
}

data class Hit(
    val id: String?,
    val ean: String?,
    val title: String?,
    val subtitle: String?,
    val pricePerUnit: Double?,
    val isOffer: Boolean?
)
