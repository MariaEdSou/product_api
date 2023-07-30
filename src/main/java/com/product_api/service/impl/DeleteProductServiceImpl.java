package com.product_api.service.impl;

import com.product_api.repository.ProductModelRepository;
import com.product_api.service.DeleteProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Log4j2
public class DeleteProductServiceImpl implements DeleteProductService {

    @Autowired
    private ProductModelRepository repository;


    @Override
    public void deleteProduct(Long id) {
        repository.findById(id)
                .ifPresentOrElse(c -> repository.delete(c),
                        () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "PRODUCT ID NOT FOUND");
                });
        log.info("PRODUCT DELETED");

    }
}
