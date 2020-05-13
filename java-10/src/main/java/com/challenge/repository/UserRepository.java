package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT u FROM User u JOIN u.candidates c WHERE c.id.acceleration.name = ?1")
    List<User> findByAccelerationName(String name);

    @Query(value = "SELECT u FROM User u JOIN u.candidates c WHERE c.id.company.id = ?1")
    List<User> findByCompanyId(Long companyId);
}
