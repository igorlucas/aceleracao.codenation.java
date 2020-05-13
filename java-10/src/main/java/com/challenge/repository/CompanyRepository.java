package com.challenge.repository;
import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query(value = "SELECT DISTINCT c FROM Company c JOIN c.candidates ca WHERE ca.id.acceleration.id = ?1")
    List<Company> findByAccelerationId(Long accelerationId);

    @Query(value = "SELECT DISTINCT c FROM Company c JOIN c.candidates ca WHERE ca.id.user.id = ?1")
    List<Company> findByUserId(Long userId);
}