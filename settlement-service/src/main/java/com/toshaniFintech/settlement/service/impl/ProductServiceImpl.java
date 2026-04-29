package com.toshaniFintech.settlement.service.impl;

import com.toshaniFintech.common.exception.model.NotFoundException;
import com.toshaniFintech.common.exception.model.UnprocessableEntityException;
import com.toshaniFintech.settlement.dto.request.ProductRequest;
import com.toshaniFintech.settlement.dto.response.ProductResponse;
import com.toshaniFintech.settlement.entity.ProductMaster;
import com.toshaniFintech.settlement.repository.ProductMasterRepository;
import com.toshaniFintech.settlement.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMasterRepository productRepository;

    @Override
    public ProductResponse createProduct(ProductRequest request) {
        if (productRepository.existsByProductNameIgnoreCase(request.getProductName())) {
            throw new UnprocessableEntityException("Product already exists with name: " + request.getProductName());
        }

        ProductMaster product = new ProductMaster();
        product.setProductUuid(UUID.randomUUID().toString());
        product.setProductName(request.getProductName());
        product.setProductDescription(request.getProductDescription());
        product.setSettlementDay(request.getSettlementDay());

        ProductMaster saved = productRepository.save(product);
        log.info("Product created: {} with settlement_day={}", saved.getProductName(), saved.getSettlementDay());
        return mapToResponse(saved);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse getProductById(String id) {
        ProductMaster product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + id));
        return mapToResponse(product);
    }

    @Override
    public ProductResponse updateProduct(String id, ProductRequest request) {
        ProductMaster product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + id));

        product.setProductName(request.getProductName());
        product.setProductDescription(request.getProductDescription());
        product.setSettlementDay(request.getSettlementDay());

        return mapToResponse(productRepository.save(product));
    }

    @Override
    public void deleteProduct(String id) {
        ProductMaster product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + id));

        if (!product.isActive()) {
            throw new com.toshaniFintech.common.exception.model.BadRequestException("Product already deleted");
        }
        // Soft delete: mark inactive rather than removing the row
        product.setActive(false);
        product.setDeletedAt(LocalDateTime.now());
        productRepository.save(product);
    }

    private ProductResponse mapToResponse(ProductMaster entity) {
        ProductResponse response = new ProductResponse();
        response.setId(entity.getId());
        response.setProductUuid(entity.getProductUuid());
        response.setProductName(entity.getProductName());
        response.setProductDescription(entity.getProductDescription());
        response.setSettlementDay(entity.getSettlementDay());
        response.setActive(entity.isActive());
        return response;
    }
}