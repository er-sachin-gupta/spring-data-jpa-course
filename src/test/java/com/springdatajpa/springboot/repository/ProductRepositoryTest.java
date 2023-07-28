package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest // To Load Full Application Test
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {
        // create product
        Product product = new Product();
        product.setName("Product 1");
        product.setSku("100ABC");
        product.setDescription("Product 1 description");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");

        // save product
        Product savedObject = productRepository.save(product);

        // display product
        System.out.println(savedObject.getId());
        System.out.println(product.toString());
    }

    @Test
    void updateUsingSaveMethod() {
        // find or retrieve an entity by id
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        // update entity information
        product.setName("updated product 1");
        product.setDescription("updated product 1 description");

        //save updated entity
        productRepository.save(product);
    }

    @Test
    void findByIdMethod() {
        Long id = 1L;

        Product product = productRepository.findById(id).get();
        System.out.println(product.toString());
    }

    @Test
    void saveAllMethod() {
        // create product
        Product product1 = new Product();
        product1.setName("Product 2");
        product1.setSku("100ABCD");
        product1.setDescription("Product 2 description");
        product1.setPrice(new BigDecimal(200));
        product1.setActive(true);
        product1.setImageUrl("product2.png");

        // create product
        Product product2 = new Product();
        product2.setName("Product 3");
        product2.setSku("100ABCDE");
        product2.setDescription("Product 3 description");
        product2.setPrice(new BigDecimal(300));
        product2.setActive(true);
        product2.setImageUrl("product3.png");

        productRepository.saveAll(List.of(product1, product2));

    }


    @Test
    void findAllMethod() {
        List<Product> products = productRepository.findAll();
        products.forEach(p -> System.out.println(p.getName()));
    }

    @Test
    void deleteByIdMethod() {
        Long id = 1L;
        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod() {

        // find an entity by id
        Long id = 2L;
        Product product = productRepository.findById(id).get();

        // delete the entity
        productRepository.delete(product);
    }

    @Test
    void deleteAllMethod() {
//        productRepository.deleteAll();

        Product product = productRepository.findById(5L).get();
        Product product1 = productRepository.findById(6L).get();

        productRepository.deleteAll(List.of(product, product1));

    }


    @Test
    void existsByIdMethod() {
        Long id = 7L;

        boolean result = productRepository.existsById(id);

        System.out.println(result);
    }

    @Test
    void countMethod() {
        long count = productRepository.count();
        System.out.println(count);
    }



}