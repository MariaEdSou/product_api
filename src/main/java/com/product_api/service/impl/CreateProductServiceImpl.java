package com.product_api.service.impl;

import com.product_api.dto.ProductRequestDTO;
import com.product_api.mapper.ProductMapper;
import com.product_api.model.ProductModel;
import com.product_api.repository.ProductModelRepository;
import com.product_api.service.CreateProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CreateProductServiceImpl implements CreateProductService {

    @Autowired
    private ProductModelRepository repository;


    @Autowired
    private ProductMapper mapper;



    @Override
    public Long start(ProductRequestDTO dto) {
        log.info("Saving product, product:{}");
         final ProductModel product = mapper.toModel(dto);
         repository.save(product);
         log.info("Saved product :{}", product);
         return product.getProduct_id();

    }
}
