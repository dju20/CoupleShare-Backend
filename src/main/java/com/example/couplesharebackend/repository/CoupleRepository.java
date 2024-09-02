package com.example.couplesharebackend.repository;


import com.example.couplesharebackend.entity.Couple;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoupleRepository extends JpaRepository<Couple, Long> {

}

