package com.ongbl.productrestapi.repositories;;


import com.ongbl.productrestapi.entity.CustomerData;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CustomerDataRepository extends JpaRepository<CustomerData, Long> {

    List<CustomerData> findALlByData(String data);


}
