package xyz.hskr.cars.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import xyz.hskr.cars.domain.Car;

public interface CarControllerInterface<T> {
	

	ResponseEntity<T> createItem(T myT);
	

	ResponseEntity<T> readItem(Long id);
	

	ResponseEntity<T> updateItem(Long id, T myT);
	

	ResponseEntity<Boolean> deleteItem(Long id);
	
	//custom
	
	ResponseEntity<List> findItemsByYear(int year);
	
	ResponseEntity<List> findItemsByModel(String model);
	
	ResponseEntity<List> findItemsByMake(String make);

	
}
