package net.bergby.norwegianbarcodelookupapi.controller

import net.bergby.norwegianbarcodelookupapi.service.BarcodeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class BarcodeController(val service: BarcodeService) {

    @GetMapping("/")
    fun index(@RequestParam("barcode") ean: String) = service.getItemFromClient(ean)
}