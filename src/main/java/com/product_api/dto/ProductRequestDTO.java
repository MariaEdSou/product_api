package com.product_api.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {

    @NotBlank
    private String product_name;
    @NotNull
    private Long stock_quantity;
    @NotNull
    private TypeProduct typeProduct;
}
