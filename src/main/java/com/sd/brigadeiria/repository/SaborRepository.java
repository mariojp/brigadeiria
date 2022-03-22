package com.sd.brigadeiria.repository;

import com.sd.brigadeiria.model.Sabor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaborRepository extends JpaRepository<Sabor, Long>{

   

}
