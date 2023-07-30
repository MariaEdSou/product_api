package com.product_api.service.impl;

import com.product_api.dto.ProductRequestUpdateDTO;
import com.product_api.model.ProductModel;
import com.product_api.repository.ProductModelRepository;
import com.product_api.service.UpdateProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;


@Service
@Log4j2
public class UpdateProductServiceImpl implements UpdateProductService {

    @Autowired
    private ProductModelRepository repository;


    @Transactional
    @Override
    public void updateProduct(Long id, ProductRequestUpdateDTO dto) {
        ProductModel productModel = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "PRODUCT NOT FOUND"));
        if (dto.getProduct_name() != null) {
            productModel.setProduct_name(dto.getProduct_name());
        }
        if (dto.getStock_quantity() != null) {
            productModel.setStock_quantity(dto.getStock_quantity());
        }
        if (dto.getTypeProduct() != null) {
            productModel.setTypeProduct(dto.getTypeProduct());
        }
        repository.save(productModel);
        log.info("UPDATE PRODUCT, {} ", productModel.getProduct_id());
    }
}
