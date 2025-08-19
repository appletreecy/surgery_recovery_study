package com.example.welcome.repository;

import com.example.welcome.model.AfterSurgeryTableTwo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AfterSurgeryTableTwoRepository extends JpaRepository<AfterSurgeryTableTwo, Long> {
}


