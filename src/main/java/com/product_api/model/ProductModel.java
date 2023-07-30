package com.product_api.model;
import com.product_api.dto.TypeProduct;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "produtos")
public class ProductModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;
    @Column(name = "nome_prod")
    private String product_name;
    @Column(name = "quant_estoque")
    private Long stock_quantity;
    @Column(name = "tipo_produto")
    @Enumerated(EnumType.STRING)
    private TypeProduct typeProduct;

}
