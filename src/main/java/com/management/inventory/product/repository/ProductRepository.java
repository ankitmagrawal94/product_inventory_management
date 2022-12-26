package com.management.inventory.product.repository;

import com.management.inventory.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(
            value = "SELECT * FROM product p WHERE p.product_name = :name and p.product_brand = :brand",
            nativeQuery = true)
    List<Product> getProductsByIdAndName(String name, String brand);

}
