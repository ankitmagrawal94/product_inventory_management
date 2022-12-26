package com.management.inventory.product.service;

import com.management.inventory.product.model.Product;
import com.management.inventory.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    Logger logger = Logger.getLogger(ProductService.class.getName());


    public String addProduct(Product product){
        try{
            logger.info("adding product");
            productRepository.save(product);
            logger.info("product added successfully");
        }catch (Exception exception){
            exception.printStackTrace();
            logger.info("Exception with the exception class "+exception.getClass());
        }

        return "product saved successfully";
    }

    public List<Product> getProductList(){
        List<Product> products = new ArrayList<>();
        try{
            logger.info("fetching all products");
            products = productRepository.findAll();
            logger.info("all products fetched successfully");
        } catch (Exception exception){
            exception.printStackTrace();
            logger.info("Exception with the exception class "+exception.getClass());
        }
        return products;

    }

    public List<Product> getProductsByCriteria(String name, String brand){
        List<Product> products = new ArrayList<>();
        try{
            logger.info("fetching products by criteria");
            products = productRepository.getProductsByIdAndName(name, brand);
            logger.info("products fetched by criteria successfully");
        } catch (Exception exception){
            exception.printStackTrace();
            logger.info("Exception with the exception class "+exception.getClass());
        }
        return products;
    }

    public Product updateProduct(Product product, int id){
        Product product1 = new Product();
        try{
            logger.info("updating a product");
            product1 = productRepository.save(product);
            logger.info("product updated successfully");
        }catch (Exception exception){
            exception.printStackTrace();
            logger.info("Exception with the exception class "+exception.getClass());
        }
        return product1;
    }

}
