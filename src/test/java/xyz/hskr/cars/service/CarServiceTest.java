package xyz.hskr.cars.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import xyz.hskr.cars.domain.Car;
import xyz.hskr.cars.repo.CarRepo;

@SpringBootTest
@ActiveProfiles("test")
public class CarServiceTest {
	
	@Autowired
	private CarService carServ;
	
	@MockBean
	private CarRepo testCarRepo;
	
	@Test
	void testCreate() {
		//given
		Car myTestCar = new Car(1994, "testFord", "testSuperFast");
		Car myTestCarReturnedValue = new Car(1L, 1994, "testFord", "testSuperFast");
		//when
		Mockito.when(testCarRepo.save(myTestCar)).thenReturn(myTestCarReturnedValue);
		//then
		assertThat(carServ.create(myTestCar)).isEqualTo(myTestCarReturnedValue);
		//verify
		Mockito.verify(testCarRepo, Mockito.times(1)).save(myTestCar);
	}
	
	@Test
	void testReadItem() {
		//given
		Car myTestCarReturnedValue = new Car(10L, 1956, "Chevrolet", "Corvette");
		Long testId = 10L;
		//when
		Mockito.when(testCarRepo.findById(testId)).thenReturn(Optional.of(myTestCarReturnedValue));
		//then
		assertThat(carServ.readItem(testId)).isEqualTo(myTestCarReturnedValue);
		//verify
		Mockito.verify(testCarRepo, Mockito.times(1)).findById(testId);
		
	}
	@Test
	void testUpdate() {
		//given
		Car myTestCar = new Car(1994, "CheeseCar", "EdamCheese");
		Car tempCar = new Car(3L, 1948, "Citroën", "2CV");
		Long testId = 3L;
		Car myTestCarReturnedValue = new Car(3L, 1994, "CheeseCar", "EdamCheese");
		//when
		Mockito.when(testCarRepo.findById(testId)).thenReturn(Optional.of(tempCar));
		Mockito.when(testCarRepo.save(myTestCar)).thenReturn(myTestCarReturnedValue);
		//then
		assertThat(carServ.update(testId, myTestCar)).isEqualTo(myTestCarReturnedValue);
		//verify
		Mockito.verify(testCarRepo, Mockito.times(1)).save(myTestCar);
		
	}	
	@Test
	void testDelete() {
		//given
		Long testId = 10L;
		Car myTestCarReturnedValue = new Car(10L, 1956, "Chevrolet", "Corvette");
		Boolean expectedReturnValue = true;
		//when
		Mockito.when(testCarRepo.findById(testId)).thenReturn(Optional.of(myTestCarReturnedValue));
		//then
		assertThat(carServ.delete(testId)).isEqualTo(expectedReturnValue);
		//verify
		Mockito.verify(testCarRepo, Mockito.times(1)).findById(testId);
		Mockito.verify(testCarRepo, Mockito.times(1)).deleteById(testId);
		
	}
}