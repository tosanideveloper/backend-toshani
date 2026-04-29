package com.toshaniFintech.settlement.controller;

import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.settlement.dto.request.ProductRequest;
import com.toshaniFintech.settlement.dto.response.ProductResponse;
import com.toshaniFintech.settlement.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@Tag(name = "Product Master API", description = "APIs for managing products and their T+N settlement cycle configuration")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "Create product", description = "Defines a product (e.g., AEPS, UPI, MATM) with its settlement_day (T+N) configuration")
    @PostMapping("/create")
    public ResponseEntity<APIResponse<ProductResponse>> createProduct(
            @Valid @RequestBody ProductRequest request) {
        return ResponseUtil.success(
                "Product created successfully",
                productService.createProduct(request),
                HttpStatus.CREATED
        );
    }

    @Operation(summary = "Get all products")
    @GetMapping("/all")
    public ResponseEntity<APIResponse<List<ProductResponse>>> getAllProducts() {
        return ResponseUtil.success(
                "Products fetched successfully",
                productService.getAllProducts(),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Get product by ID")
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<ProductResponse>> getProductById(@PathVariable String id) {
        return ResponseUtil.success(
                "Product fetched successfully",
                productService.getProductById(id),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Update product", description = "Update product name, description, or settlement_day (T+N)")
    @PutMapping("/update/{id}")
    public ResponseEntity<APIResponse<ProductResponse>> updateProduct(
            @PathVariable String id,
            @Valid @RequestBody ProductRequest request) {
        return ResponseUtil.success(
                "Product updated successfully",
                productService.updateProduct(id, request),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Delete product (soft delete)")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<APIResponse<Object>> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return ResponseUtil.success(
                "Product deleted successfully",
                null,
                HttpStatus.OK
        );
    }
}