package com.product_api.mapper;

import com.product_api.dto.ProductRequestDTO;
import com.product_api.dto.ProductRequestUpdateDTO;
import com.product_api.dto.ProductResponseDTO;
import com.product_api.model.ProductModel;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductModel toModel(ProductRequestDTO productDTO);

    ProductResponseDTO toDTO(ProductModel productModel);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(@MappingTarget ProductModel productModel, ProductRequestUpdateDTO dto);
}
