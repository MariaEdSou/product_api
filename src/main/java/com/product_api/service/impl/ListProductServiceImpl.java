package com.product_api.service.impl;

import com.product_api.dto.ProductResponseDTO;
import com.product_api.exceptions.BusinessException;
import com.product_api.mapper.ProductMapper;
import com.product_api.model.ProductModel;
import com.product_api.repository.ProductModelRepository;
import com.product_api.service.ListProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@Log4j2
public class ListProductServiceImpl implements ListProductService {

    @Autowired
    private ProductModelRepository repository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public ProductResponseDTO list(Long id) {
        Optional<ProductModel> productModelOptional = repository.findById(id);

        if (productModelOptional.isPresent()) {
            ProductResponseDTO productResponseDTO = mapper.toDTO(productModelOptional.get());
            log.info("listing product, product:{}", productResponseDTO);
            return productResponseDTO;
        }
        throw new BusinessException(NOT_FOUND, "Product is not present ");
    }
}
