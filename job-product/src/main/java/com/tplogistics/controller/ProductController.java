package com.tplogistics.controller;

import com.tplogistics.controller.dto.request.create.ProductCreateRequest;
import com.tplogistics.controller.dto.response.ProductResponse;
import com.tplogistics.core.domain.entity.Product;
import com.tplogistics.core.service.ProductService;
import controller.base.BaseController;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/product")
public class ProductController extends BaseController {

    private final ProductService productService;
    private final ModelMapper modelMapper;

    @PostMapping("v1/create")
    ResponseEntity<Object> createProduct(@RequestBody ProductCreateRequest request) {
        return successResponse(productService.createProduct(request));
    }

    @GetMapping("v1/get/{id}")
    ResponseEntity<Object> findProductById(@PathVariable String id) {
        UUID uuid = UUID.fromString(id);
        Product product = productService.findProduct(uuid);

        ProductResponse response = modelMapper.map(product, ProductResponse.class);
        return successResponse(response);
    }

    @GetMapping("v1/list")
    ResponseEntity<Object> findProductByName(@RequestParam String keyword) {
        List<Product> products = productService.findProductByName(keyword);
        List<ProductResponse> response = products.stream()
                .map( route ->
                        modelMapper.map(route, ProductResponse.class)
                ).toList();
        return successResponse(response);
    }

}
