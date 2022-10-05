package com.tplogistics.core.service;

import com.tplogistics.controller.dto.request.create.ProductCreateRequest;
import com.tplogistics.core.domain.entity.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    UUID createProduct(ProductCreateRequest request);

    Product findProduct(UUID id);

    List<Product> findProductByName(String keyword);
}
