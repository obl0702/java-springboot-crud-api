package com.ongbl.productrestapi.repositories;;

import com.ongbl.productrestapi.entity.BatchJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchJobRepository extends JpaRepository<BatchJob, Long> {
}
