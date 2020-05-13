package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, CandidateId> {

    @Query(value = "SELECT c FROM Candidate c WHERE c.id.user.id= ?1 AND c.id.company.id = ?2 AND c.id.acceleration.id = ?3")
    Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId);

    @Query(value = "SELECT c FROM Candidate c WHERE c.id.company.id = :companyId")
    List<Candidate> findByCompanyId(@Param("companyId") Long companyId);

    @Query(value = "SELECT c FROM Candidate c WHERE c.id.acceleration.id = :accelerationId")
    List<Candidate> findByAccelerationId(@Param("accelerationId") Long accelerationId);
}
