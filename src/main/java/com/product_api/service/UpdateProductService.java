package com.product_api.service;

import com.product_api.dto.ProductRequestUpdateDTO;

public interface UpdateProductService {

    void updateProduct(Long id, ProductRequestUpdateDTO dto);

}
