package xyz.hskr.cars.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface CarControllerInterface<T> {
	

	ResponseEntity<T> createItem(T myT);
	

	ResponseEntity<T> readItem(Long id);
	

	ResponseEntity<T> updateItem(Long id, T myT);
	

	ResponseEntity<Boolean> deleteItem(Long id);

}
