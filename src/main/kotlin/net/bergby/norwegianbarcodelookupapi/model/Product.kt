package net.bergby.norwegianbarcodelookupapi.model

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Product (
        @Id
        var barcode: String,
        var name: String,
        var price: Double,
        var size: String
)