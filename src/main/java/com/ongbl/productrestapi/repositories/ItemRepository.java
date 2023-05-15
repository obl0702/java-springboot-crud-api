package com.ongbl.productrestapi.repositories;

import com.ongbl.productrestapi.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Modifying(flushAutomatically = true,clearAutomatically = true)
    @Query("UPDATE Item SET status = :status WHERE id IN :ids")
    void updateItemsByIdIn(@Param("status") String status,
                           @Param("ids") List<Long> ids);
}