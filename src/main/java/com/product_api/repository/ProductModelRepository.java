package com.product_api.repository;
import com.product_api.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductModelRepository extends JpaRepository<ProductModel,Long> {
    void save(long quantProduct);

}
