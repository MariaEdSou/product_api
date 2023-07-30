package com.product_api.service;

import com.product_api.dto.ProductInformationRequestDTO;
import com.product_api.model.ProductModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public interface QuantityEncumbranceService {

    void checkQuantity(List<ProductInformationRequestDTO> dto);

}
