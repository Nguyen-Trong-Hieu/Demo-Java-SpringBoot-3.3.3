package com.hieuproject.demo.Service;


import com.hieuproject.demo.Dto.Request.ProductCreationRequest;
import com.hieuproject.demo.Dto.Request.ProductUpdateRequest;
import com.hieuproject.demo.Entity.Product;
import com.hieuproject.demo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(ProductCreationRequest request){
        Product product = new Product();

        product.setProductName(request.getProductName());
        product.setDescription(request.getDescription());
        product.setCategoryName(request.getCategoryName());
        product.setQuantity(request.getQuantity());
        product.setSKU(request.getSKU());
        product.setCreatedDate(request.getCreatedDate());

        return productRepository.save(product);
    }
    public Product updateProduct(long productId,ProductUpdateRequest request){
        Product product = getProduct(productId);

        product.setProductName(request.getProductName());
        product.setDescription(request.getDescription());
        product.setCategoryName(request.getCategoryName());
        product.setQuantity(request.getQuantity());

        return productRepository.save(product);
    }

    public void deleteProduct(long productId){
        productRepository.deleteById(productId);
    }

    public List<Product> getProducts(){return productRepository.findAll();}

    public Product getProduct(long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found Product !"));
    }


}
