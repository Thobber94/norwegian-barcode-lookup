package net.bergby.norwegianbarcodelookupapi.service

import net.bergby.norwegianbarcodelookupapi.client.MenyClient
import org.springframework.stereotype.Service

@Service
class BarcodeService(val client: MenyClient) {
    fun getItemFromClient(ean: String) = client.callMenyApiWithBarcode(ean).hits.first()
}