package com.tplogistics.core.service.impl;

import com.tplogistics.controller.dto.request.ProductCreateRequest;
import com.tplogistics.controller.dto.request.RouteCreateRequest;
import com.tplogistics.core.domain.entity.Product;
import com.tplogistics.core.domain.entity.Route;
import com.tplogistics.core.error_handling.custom_error.InvalidRequest;
import com.tplogistics.core.error_handling.custom_error.RouteNotFound;
import com.tplogistics.core.service.LocationService;
import com.tplogistics.core.service.ProductService;
import com.tplogistics.core.service.RouteService;
import com.tplogistics.repository.ProductRepository;
import com.tplogistics.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public UUID createProduct(ProductCreateRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .unit(request.getUnit())
                .type(request.getType())
                .build();
        var result = productRepository.save(product);

        return result.getProductId();
    }

    @Override
    public Product findProduct(UUID id) {
        var result = productRepository.findById(id);
        if (result.isEmpty()) {
            throw new RouteNotFound("Product not found");
        }
        return result.get();
    }

    @Override
    public List<Product> findProductByName(String keyword) {
        if (keyword.isBlank()) {
            throw new InvalidRequest("Invalid product name");
        }

        List<Product> products = new ArrayList<>();
        products = productRepository.findByIgnoreCaseNameContaining(keyword);

        return products;
    }
}
