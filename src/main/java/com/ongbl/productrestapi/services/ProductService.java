package com.ongbl.productrestapi.services;

import com.ongbl.productrestapi.model.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getAllProducts(Integer pageNo, Integer pageSize, String sortBy);

    ProductDTO getProductByCode(String code);

    ProductDTO createNewProducts(ProductDTO productDTO);

    ProductDTO updateProduct(String code, ProductDTO productDTO);

    void deleteProduct(String code);

    void updateItems(List<Long> id);

}
