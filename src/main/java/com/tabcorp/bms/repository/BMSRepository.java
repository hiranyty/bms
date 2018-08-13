package com.tabcorp.bms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tabcorp.bms.model.BMSDetails;

@Repository
public interface BMSRepository extends CrudRepository<BMSDetails, Long> {
	List<BMSDetails> findByBetType(String betType);
	
	@Query("SELECT DISTINCT bms.betType FROM  BMSDetails bms")
    List<String> findDistinctBetType();
	
	List<BMSDetails> findByCustomerId(Long customerID);
	
	@Query("SELECT DISTINCT bms.customerId FROM  BMSDetails bms")
	List<Long> findDistinctCustomerId();
	
	@Query("SELECT COUNT(*) FROM BMSDetails bms WHERE bms.createdDate > DATEADD(HOUR, -1, CURRENT_TIMESTAMP())")
	Long findTotalBetsPerHour();
	
	@Query("SELECT COUNT(*) FROM BMSDetails bms WHERE bms.betType = :betType")
	Long findTotalBetsPerBetType(@Param("betType") String betType);
	
}
