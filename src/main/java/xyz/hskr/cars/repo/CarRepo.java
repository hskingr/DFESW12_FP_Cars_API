package xyz.hskr.cars.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import xyz.hskr.cars.domain.Car;

@Repository
public interface CarRepo extends JpaRepository<Car, Long>{
	
	List<Car> findCarByYear(int year);
	
	List<Car> findCarByModel(String model);
	
	List<Car> findCarByMake(String make);

}

