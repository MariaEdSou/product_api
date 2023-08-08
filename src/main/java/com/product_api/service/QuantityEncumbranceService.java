package com.product_api.service;

import com.product_api.dto.ProductInformationRequestDTO;
import java.util.List;

public interface QuantityEncumbranceService {

    void checkQuantity(List<ProductInformationRequestDTO> dto);

}
