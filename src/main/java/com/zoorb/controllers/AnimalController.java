package com.zoorb.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zoorb.model.Animal;
import com.zoorb.services.AnimalService;


@Controller
//@RequestMapping("animals")
public class AnimalController {
	
	
	@Autowired
    AnimalService animalService;
	
	 @GetMapping("/")
	    public String animalHome() {
	        return "home.html";
	    }

    @GetMapping("/showall")
    @ResponseBody
    public List<Animal> getAllAnimal() {
        return animalService.getAllAnimal();
    }

    @PostMapping(value = "/animaladd")
	@ResponseBody
	public Animal addAnimal(Animal animal) {
		animalService.addAnimal(animal);
		return animal;
	}

	@RequestMapping("/status")
	@ResponseBody
	public List<Animal> getAllAnimalByStatus(@RequestParam String status) {
		return animalService.getAllAnimalByStatus(status);
	}
	
	@GetMapping("/Animalshow")
	public String viewHome(Model model) {
	model.addAttribute("alllist", animalService.getAllAnimalByStatus("quarantined"));
	return "status.html";
	}
	
	@GetMapping("/viewA")
	public String viewAnimals(Model model) {
	model.addAttribute("givelist", animalService.getAllAnimal());
	return "showanimal.html";
	}

}
