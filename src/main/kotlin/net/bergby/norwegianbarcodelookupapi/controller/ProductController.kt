package net.bergby.norwegianbarcodelookupapi.controller

import net.bergby.norwegianbarcodelookupapi.service.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/api/barcode")
class ProductController(
        val productService: ProductService
) {

    @GetMapping("/{barcode}")
    fun findProduct(@PathVariable(value = "barcode") barcode: String) =
            productService.getProduct(barcode)
}