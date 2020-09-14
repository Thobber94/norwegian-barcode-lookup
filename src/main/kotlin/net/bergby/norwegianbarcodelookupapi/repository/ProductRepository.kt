package net.bergby.norwegianbarcodelookupapi.repository

import net.bergby.norwegianbarcodelookupapi.model.Product
import org.springframework.data.repository.CrudRepository

interface ProductRepository : CrudRepository<Product, String> {
    fun findProductByBarcode(barcode: String): Product?
}