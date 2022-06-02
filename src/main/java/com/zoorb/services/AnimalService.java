package com.zoorb.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoorb.model.Animal;
import com.zoorb.repository.AnimalRepository;


@Service
public class AnimalService {

	@Autowired
	AnimalRepository animalRepo;

    public List<Animal> getAllAnimal() {
        List<Animal> animals = new ArrayList<>();
        animalRepo.findAll().forEach(animal -> animals.add(animal));
        return animals;
    }
    
    public void addAnimal(Animal animal) {
    	animalRepo.save(animal);
    }
    
    public List<Animal> getAllAnimalByStatus(String status) {
		List<Animal> animals = new ArrayList<>();

		animalRepo.findByStatus(status).forEach(animal -> animals.add(animal));
		return animals;
	}
    
}
