package com.ongbl.productrestapi.spec;

import com.ongbl.productrestapi.model.ProductDTO;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ProductSpecification implements Specification<ProductDTO> {

    @Override
    public Predicate toPredicate(Root<ProductDTO> productDTO,
                                 CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        //List<>
        return null;
    }

}
