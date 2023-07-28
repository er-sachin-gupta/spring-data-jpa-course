package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class QueryMethodsTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod() {
        Product product = productRepository.findByName("product 2");
        System.out.println(product.toString());
    }

    @Test
    void findByIdMethod() {
        Optional<Product> productOptional = productRepository.findById(1L);
        Product product = productOptional.get();
        System.out.println(product.toString());
    }

    @Test
    void findByNameOrDescriptionMethod() {
        List<Product> products = productRepository.findByNameOrDescription("product 1",
                "product 1 description");
        products.forEach(p -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByNameAndDescriptionMethod() {
        List<Product> products = productRepository.findByNameAndDescription("product 11",
                "product 1 description");
        products.forEach(p -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findDistinctByNameMethod() {
        Product product = productRepository.findDistinctByName("product 1");
        System.out.println(product.toString());
    }

    @Test
    void findByPriceGreaterThanMethod() {
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(100));
        products.forEach(p -> {
            System.out.println(p.getName());
            System.out.println(p.getPrice());
        });
    }

    @Test
    void findByLessThanPriceMethod() {
        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(200));
        products.forEach(p -> {
            System.out.println(p.getName());
            System.out.println(p.getPrice());
        });
    }

    @Test
    void findByNameContainingMethod() {
        List<Product> products = productRepository.findByNameContaining("product");
        products.forEach(p -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByNameLikeMethod() {
        List<Product> products = productRepository.findByNameLike("product");
        products.forEach(p -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByPriceBetweenMethod() {
        List<Product> products = productRepository.findByPriceBetween(new BigDecimal(100),
                new BigDecimal(300));
        products.forEach(p -> {
            System.out.println(p.getName());
            System.out.println(p.getPrice());
        });
    }

    @Test
    void findByDateCreatedBetweenMethod() {
        // start Date
        LocalDateTime startDate =  LocalDateTime.of(2023, 07, 28, 16, 54, 05);

        // end Date
        LocalDateTime endDate = LocalDateTime.of(2023, 07, 28, 17, 36, 42);

        List<Product> products = productRepository.findByDateCreatedBetween(startDate, endDate);

        products.forEach(p -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getPrice());
        });
    }

    @Test
    void findByNameInMethod() {
        List<Product> products = productRepository.findByNameIn(List.of("product 1", "product 2", "product 3"));
        products.forEach(p -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }


    @Test
    void findFirst2ByOrderByNameAscMethod() {
        List<Product> products = productRepository.findFirst2ByOrderByNameAsc();
        products.forEach(p -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findTop3ByOrderByPriceDescMethod() {
        List<Product> products = productRepository.findTop3ByOrderByPriceDesc();
        products.forEach(p -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }


}
