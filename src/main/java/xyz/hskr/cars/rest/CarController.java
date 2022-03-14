package xyz.hskr.cars.rest;

import java.util.NoSuchElementException;

import org.aspectj.weaver.ast.Instanceof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import xyz.hskr.cars.domain.Car;
import xyz.hskr.cars.service.CarService;
import xyz.hskr.exception.BodyParamaterException;
import xyz.hskr.exception.NoSuchElementFoundException;

@RestController
public class CarController implements CarControllerInterface<Car> {

	@Autowired
	private CarService myCarService;

	@Override
	@PostMapping("/createItem")
	public ResponseEntity<Car> createItem(@RequestBody Car myCar) {
			return new ResponseEntity<>(myCarService.create(myCar), HttpStatus.CREATED);
	}
	

	@Override
	@GetMapping("/readItem/{id}")
	public ResponseEntity<Car> readItem(@PathVariable Long id) {
			return new ResponseEntity<>(myCarService.readItem(id), HttpStatus.OK);
	}

	@Override
	@PutMapping("/updateItem/{id}")
	public ResponseEntity<Car> updateItem(@PathVariable Long id, @RequestBody Car myCar) {
			return new ResponseEntity<>(myCarService.update(id, myCar), HttpStatus.CREATED);
	}

	@Override
	@DeleteMapping("/deleteItem/{id}")
	public ResponseEntity<Boolean> deleteItem(@PathVariable Long id) {
			return new ResponseEntity<>(myCarService.delete(id), HttpStatus.ACCEPTED);
	}

}
