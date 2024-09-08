package com.hieuproject.demo.Mapper;

import com.hieuproject.demo.Dto.Request.ProductCreationRequest;
import com.hieuproject.demo.Entity.Product;
import com.hieuproject.demo.Service.ProductService;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    Product toproduct (ProductCreationRequest request);
}
