package com.product_api.controller;

import com.product_api.dto.ProductInformationRequestDTO;
import com.product_api.dto.ProductRequestDTO;
import com.product_api.dto.ProductRequestUpdateDTO;
import com.product_api.dto.ProductResponseDTO;
import com.product_api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @Autowired
    CreateProductService createservice;

    @Autowired
    ListProductService listservice;

    @Autowired
    UpdateProductService updateService;

    @Autowired
    DeleteProductService deleteService;

    @Autowired
    QuantityEncumbranceService quantityService;

    @PostMapping
    public ResponseEntity<Void> post(@RequestBody @Valid final ProductRequestDTO dto)
            throws URISyntaxException {
        final var productId = createservice.start(dto);
        return ResponseEntity.created(new URI("/v1/product" + productId)).build();
    }

    @PostMapping("/encumber")
    public ResponseEntity<Void> quantity(@RequestBody @Valid List<ProductInformationRequestDTO> dto) {
        quantityService.checkQuantity(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> list(@PathVariable Long id) {
        ProductResponseDTO productResponseDTO = listservice.list(id);
        return ResponseEntity.ok(productResponseDTO);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody ProductRequestUpdateDTO dto) {
        updateService.updateProduct(id, dto);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}

