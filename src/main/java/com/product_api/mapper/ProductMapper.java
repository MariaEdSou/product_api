package com.product_api.mapper;
import com.product_api.dto.ProductRequestDTO;
import com.product_api.dto.ProductRequestUpdateDTO;
import com.product_api.dto.ProductResponseDTO;
import com.product_api.model.ProductModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductModel toModel(ProductRequestDTO productDTO);

    ProductResponseDTO toDTO(ProductModel productModel);


//    @Mapping
//    void update(@MappingTarget ProductModel productModel, ProductRequestUpdateDTO dto);
}
