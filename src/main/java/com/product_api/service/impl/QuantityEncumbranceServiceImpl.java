package com.product_api.service.impl;

import com.product_api.dto.ProductInformationRequestDTO;
import com.product_api.exceptions.BusinessException;
import com.product_api.model.ProductModel;
import com.product_api.repository.ProductModelRepository;
import com.product_api.service.QuantityEncumbranceService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@Log4j2
public class QuantityEncumbranceServiceImpl implements QuantityEncumbranceService {

    @Autowired
    private ProductModelRepository repository;

    @Transactional
    @Override
    public void checkQuantity(List<ProductInformationRequestDTO> dto) {
        dto.forEach(productDTO -> {
            ProductModel product = repository.findById(productDTO.getProductId())
                    .orElseThrow(() -> new BusinessException(NOT_FOUND, " PRODUCT NOT FOUND ID: " + productDTO.getProductId()));

            if (productDTO.getQuantity() <= product.getStock_quantity()) {
                long quantProduct = product.getStock_quantity() - productDTO.getQuantity();
                product.setStock_quantity(quantProduct);
                repository.save(product);
                log.info("CHANGED QUANTITY, {} ", product.getStock_quantity());
            }
            else {
            throw new BusinessException(HttpStatus.UNPROCESSABLE_ENTITY, "DO NOT HAVE THIS QUANTITY IN STOCK: PRODUCT ID " + productDTO.getProductId());
        }});
    }
}

