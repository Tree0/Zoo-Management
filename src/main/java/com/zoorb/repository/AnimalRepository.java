package com.zoorb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zoorb.model.Animal;

public interface AnimalRepository extends CrudRepository<Animal, Integer> {
	List<Animal> findByStatus(String status);

}
