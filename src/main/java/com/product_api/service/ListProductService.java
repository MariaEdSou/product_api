package com.product_api.service;

import com.product_api.dto.ProductResponseDTO;

public interface ListProductService {

    ProductResponseDTO list(Long id);
}
