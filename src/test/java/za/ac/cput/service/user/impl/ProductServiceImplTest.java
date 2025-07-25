package za.ac.cput.service.user.impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.ProductFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductServiceImplTest {

    private static Product product;

    @Autowired
    private ProductServiceImpl service;

    @BeforeAll
    static void setUp() {
        List<String> categories = new ArrayList<>();
        product = ProductFactory.createProduct(1, "Multistage", "Nibbles", "placeholder.jpg", 4f, 249.99, 199.99, true, 23, 1.34, "Jock", "Adult", "Dry", "Dog", "Lamb", categories);}

        @Test
        @Order(1)
        void create() {
            Product created = service.create(product);
            assertNotNull(created);
            System.out.println(created);
        }

        @Test
        @Order(2)
        void read() {
            Product read = service.read(product.getProductID());
            assertNotNull(read);
            System.out.println(read);
        }

        @Test
        @Order(3)
        void update() {
            Product updatedProduct = new Product.Builder().copy(product).setBrand("Dogmoor").build();
            Product updated = service.update(updatedProduct);
            assertNotNull(updated);
            System.out.println(updated);
        }

        @Test
        @Order(5)
        void delete() {
            service.delete(product.getProductID());
            Product deleted = service.read(product.getProductID());
            assertNull(deleted);
            System.out.println(deleted);
        }

        @Test
        @Order(4)
        void getAll() {
            List<Product> products = service.getAll();
            assertNotNull(products);
            System.out.println(products);
        }

        @Test
        @Disabled
        void findByProductName() {
            Product foundByProductName = service.findByProductName(product.getProductName());
            assertNotNull(foundByProductName);
            System.out.println(foundByProductName);
        }

   @Test
    @Disabled
    void findByProductID() {
        Product foundByProductID = service.findByProductID(product.getProductID());
        assertNotNull(foundByProductID);
        System.out.println(foundByProductID);
    }

}
