package com.zoorb.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Animaltab")
public class Animal implements Serializable{

	// @NotNull(message="animalName should not be null")
	// @Pattern(regexp="^[a-zA-Z0-9]{3}",message="animalName length must be 3 and it
	// should be only alphanumeric chars")
	@Id
	String animalName;

	String animalType;

	// @NotNull(message="age should not be null")
	// @Min(value=1, message="age should not be atleast 1 year")
	int animalAge;

	String status;

}
