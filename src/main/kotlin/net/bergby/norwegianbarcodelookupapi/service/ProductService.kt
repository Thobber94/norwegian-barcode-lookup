package net.bergby.norwegianbarcodelookupapi.service

import net.bergby.norwegianbarcodelookupapi.model.Product

interface ProductService {
    fun getProduct(barcode: String): Product
}