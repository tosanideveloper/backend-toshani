package com.toshaniFintech.settlement.service;

import com.toshaniFintech.settlement.dto.request.ProductRequest;
import com.toshaniFintech.settlement.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse createProduct(ProductRequest request);

    List<ProductResponse> getAllProducts();

    ProductResponse getProductById(String id);

    ProductResponse updateProduct(String id, ProductRequest request);

    void deleteProduct(String id);
}