package com.tom.bhxhsqa.repository;

import com.tom.bhxhsqa.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query(value = "SELECT nextval('item_id_seq')", nativeQuery = true)
    Long getNextSeriesId();

}
