package com.management.inventory.product.controller;

import com.management.inventory.product.model.Product;
import com.management.inventory.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public String addNewProduct(@RequestBody Product product){
        String message = productService.addProduct(product);
        return message;
    }

    @GetMapping("getAllProducts")
    public List<Product> getProducts(){
        return productService.getProductList();
    }

    @GetMapping("getProductsByCondition")
    public List<Product> getProductsByCondition(@RequestParam String name, @RequestParam String brand){
        return productService.getProductsByCriteria(name, brand);
    }

    @PutMapping("/updateProduct/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable int id){
        return productService.updateProduct(product,id);
    }

}
