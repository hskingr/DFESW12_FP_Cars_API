package xyz.hskr.cars.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int year;
	private String make;
	private String model;
	
	public Car(int year, String make, String model, Long id) {
		super();
		this.id = id;
		this.year = year;
		this.make = make;
		this.model = model;
	} 
	
	public Car(int year, String make, String model) {
		super();
		this.year = year;
		this.make = make;
		this.model = model;
	} 
//	
//	public Car() {
//		
//	}
	
}


