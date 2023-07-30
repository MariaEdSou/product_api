package com.product_api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductInformationRequestDTO {

    @NotNull
    private Long productId;
    @NotNull
    private Long quantity;
}
