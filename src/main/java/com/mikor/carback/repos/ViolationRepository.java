package com.mikor.carback.repos;

import com.mikor.carback.models.Violation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViolationRepository extends JpaRepository<Violation, Long> {

}
