package xyz.hskr.cars.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xyz.hskr.cars.domain.Car;

@Repository
public interface CarRepo extends JpaRepository<Car, Long>{
	
}

