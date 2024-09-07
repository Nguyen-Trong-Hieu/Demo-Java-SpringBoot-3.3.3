package com.hieuproject.demo.Controller;

import ch.qos.logback.core.model.Model;
import com.hieuproject.demo.Dto.Request.ProductCreationRequest;
import com.hieuproject.demo.Dto.Request.ProductUpdateRequest;
import com.hieuproject.demo.Entity.Product;
import com.hieuproject.demo.Service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired private ProductService productService;

    @PostMapping
    Product createProduct(@RequestBody @Valid ProductCreationRequest request){
        return productService.createProduct(request);
    }

    @GetMapping
    List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/{productId}")
    Product getProduct(@PathVariable("productId") long productId){
        return productService.getProduct(productId);
    }

    @PutMapping("/{productId}")
    Product updateProduct(@PathVariable("productId") long productId, @RequestBody ProductUpdateRequest request){
        return productService.updateProduct(productId,request);
    }

    @DeleteMapping("/{productId}")
    String deleteProduct(@PathVariable long productId){
        productService.deleteProduct(productId);
        return "Product is deleted successfully !";
    }


}
