package com.product_api.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestUpdateDTO {

    private String product_name;
    private Long stock_quantity;
    private TypeProduct typeProduct;


}
