package com.tplogistics.core.service.impl;

import com.tplogistics.controller.dto.request.create.ProductCreateRequest;
import com.tplogistics.core.domain.entity.Product;
import com.tplogistics.core.domain.enums.ProductType;
import com.tplogistics.core.error_handling.custom_error.InvalidRequestException;
import com.tplogistics.core.error_handling.custom_error.NotFoundException;
import com.tplogistics.core.service.ProductService;
import com.tplogistics.repository.ProductRepository;
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
        if (ProductType.fromInt(request.getType()) == null) {
            throw new NotFoundException("Product type does not exist");
        }

        Product product = Product.builder()
                .name(request.getName())
                .unit(request.getUnit())
                .type(request.getType())
                .basePrice(request.getBasePrice())
                .build();
        var result = productRepository.save(product);

        return result.getProductId();
    }

    @Override
    public Product findProduct(UUID id) {
        var result = productRepository.findById(id);
        if (result.isEmpty()) {
            throw new NotFoundException("Product not found");
        }
        return result.get();
    }

    @Override
    public List<Product> findProductByName(String keyword) {
        if (keyword.isBlank()) {
            throw new InvalidRequestException("Invalid product name");
        }

        List<Product> products = new ArrayList<>();
        products = productRepository.findByIgnoreCaseNameContaining(keyword);

        return products;
    }
}
