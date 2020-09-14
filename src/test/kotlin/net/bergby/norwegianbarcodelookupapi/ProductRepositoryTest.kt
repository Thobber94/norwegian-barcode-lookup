package net.bergby.norwegianbarcodelookupapi

import net.bergby.norwegianbarcodelookupapi.model.Product
import net.bergby.norwegianbarcodelookupapi.repository.ProductRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest @Autowired constructor(
        val entityManager: TestEntityManager,
        val productRepository: ProductRepository
) {
    @Test
    fun persist() {
        val product = Product(
                barcode = "123456789",
                name = "TestProduct",
                price = 100.10,
                size = "1.5"
        )
        entityManager.persist(product)
        entityManager.flush()
        val foundProduct = productRepository.findProductByBarcode(product.barcode)
        assertThat(foundProduct).isEqualTo(product)
    }
}