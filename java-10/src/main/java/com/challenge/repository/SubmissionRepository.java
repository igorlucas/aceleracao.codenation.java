package com.challenge.repository;
import com.challenge.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {

    @Query(value = "SELECT s.* FROM Submission s, Challenge c, Acceleration a WHERE s.Challenge_id = c.id AND c.id = a.Challenge_id AND s.Challenge_id = :challengeId AND a.id = :accelerationId", nativeQuery = true)
    List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId,@Param("accelerationId") Long accelerationId);

    @Query(value = "SELECT nvl2(MAX(s.score), MAX(s.score), 0) FROM Submission s WHERE s.Challenge_id = ?1", nativeQuery = true)
    BigDecimal findHigherScoreByChallengeId(Long challengeId);
}
