package com.ongbl.productrestapi.repositories;

import com.ongbl.productrestapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> getProductByCode(String code);
}
