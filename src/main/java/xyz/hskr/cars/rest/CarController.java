package xyz.hskr.cars.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.hskr.cars.domain.Car;
import xyz.hskr.cars.service.CarService;

@CrossOrigin(maxAge = 3600)
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

	
	
	
	//custom

	@Override
	@GetMapping("/findItemsByYear/{year}")
	public ResponseEntity<List> findItemsByYear(@PathVariable int year) {
		return new ResponseEntity<>(myCarService.findItemsByYear(year), HttpStatus.OK);
	}

	@Override
	@GetMapping("/findItemsByModel/{model}")
	public ResponseEntity<List> findItemsByModel(@PathVariable String model) {
		return new ResponseEntity<>(myCarService.findItemsByModel(model), HttpStatus.OK);
	}


	@Override
	@GetMapping("/findItemsByMake/{make}")
	public ResponseEntity<List> findItemsByMake(@PathVariable String make) {
		return new ResponseEntity<>(myCarService.findItemsByMake(make), HttpStatus.OK);
	}

}
