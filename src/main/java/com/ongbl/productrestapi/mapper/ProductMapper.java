package com.ongbl.productrestapi.mapper;

import com.ongbl.productrestapi.entity.Product;
import com.ongbl.productrestapi.model.ProductDTO;

public interface ProductMapper {

    ProductDTO productToProductDTO(Product product);

    Product productDtoToProduct(ProductDTO productDTO);

}
