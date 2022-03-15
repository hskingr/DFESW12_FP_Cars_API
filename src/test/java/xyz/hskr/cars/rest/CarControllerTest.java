package xyz.hskr.cars.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import xyz.hskr.cars.domain.Car;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class CarControllerTest {
	@Autowired
	private MockMvc myMock;
	@Autowired
	ObjectMapper myMap;

	

	@Test
	void testCreateItem() throws Exception {
		// request
		Car create = new Car(1994, "testFord", "testSuperFast");
		String createJSON = myMap.writeValueAsString(create);

		RequestBuilder myMockRequest = post("/createItem").contentType(MediaType.APPLICATION_JSON).content(createJSON);
		// response
		Car created = new Car(7269L, 1994, "testFord", "testSuperFast");
		String createdJSON = myMap.writeValueAsString(created);
		ResultMatcher matchStatus = status().is(201);
		ResultMatcher matchBody = content().json(createdJSON);
		// test
		myMock.perform(myMockRequest).andExpect(matchStatus).andExpect(matchBody);
	}

	@Test
	void testReadItem() throws Exception {
		// request
		Long id = 10L;

		RequestBuilder myMockRequest = get("/readItem/{id}", id);
		// response
		Car returnedItem = new Car(10L, 1956, "Chevrolet", "Corvette");
		String returnedJSON = myMap.writeValueAsString(returnedItem);
		ResultMatcher matchStatus = status().is(200);
		ResultMatcher matchBody = content().json(returnedJSON);
		// test
		myMock.perform(myMockRequest).andExpect(matchStatus).andExpect(matchBody);
	}


	@Test
	void testUpdateItem() throws Exception {
		// request
		Car updateItem = new Car(1994, "CheeseCar", "EdamCheese");
		Long id = 3L;
		String updateJSON = myMap.writeValueAsString(updateItem);

		RequestBuilder myMockRequest = put("/updateItem/{id}", id).contentType(MediaType.APPLICATION_JSON)
				.content(updateJSON);
		// response
		Car returnedItem = new Car(id, 1994, "CheeseCar", "EdamCheese");
		String createdJSON = myMap.writeValueAsString(returnedItem);
		ResultMatcher matchStatus = status().is(201);
		ResultMatcher matchBody = content().json(createdJSON);
		// test
		myMock.perform(myMockRequest).andExpect(matchStatus).andExpect(matchBody);
	}

	@Test
	void testDeleteItem() throws Exception {
		// request
		Long id = 10L;
		RequestBuilder myMockRequest = delete("/deleteItem/{id}", id);
		// response
		ResultMatcher matchStatus = status().is(202);
		ResultMatcher matchBody = content().string("true");
		// test
		myMock.perform(myMockRequest).andExpect(matchStatus).andExpect(matchBody);
	}
	
	@Test
	void testFindItemsByYear() throws Exception {
		// request
		int year = 1950;

		RequestBuilder myMockRequest = get("/findItemsByYear/{year}", year);
		// response
		Car returnedItem = new Car(4L, 1950, "Hillman", "Minx Magnificent");
		List<Car> savedList = new ArrayList<>();
		savedList.add(returnedItem);
		String returnedJSON = myMap.writeValueAsString(savedList);
		ResultMatcher matchStatus = status().is(200);
		ResultMatcher matchBody = content().json(returnedJSON);
		// test
		myMock.perform(myMockRequest).andExpect(matchStatus).andExpect(matchBody);
	}
	
	@Test
	void testFindItemsByModel() throws Exception {
		// request
		String model = "Minx Magnificent";

		RequestBuilder myMockRequest = get("/findItemsByModel/{model}", model);
		// response
		Car returnedItem = new Car(4L, 1950, "Hillman", "Minx Magnificent");
		List<Car> savedList = new ArrayList<>();
		savedList.add(returnedItem);
		String returnedJSON = myMap.writeValueAsString(savedList);
		ResultMatcher matchStatus = status().is(200);
		ResultMatcher matchBody = content().json(returnedJSON);
		// test
		myMock.perform(myMockRequest).andExpect(matchStatus).andExpect(matchBody);
	}
	
	@Test
	void testFindItemsByMake() throws Exception {
		// request
		String make = "Hillman";

		RequestBuilder myMockRequest = get("/findItemsByMake/{make}", make);
		// response
		Car returnedItem = new Car(4L, 1950, "Hillman", "Minx Magnificent");
		List<Car> savedList = new ArrayList<>();
		savedList.add(returnedItem);
		String returnedJSON = myMap.writeValueAsString(savedList);
		ResultMatcher matchStatus = status().is(200);
		ResultMatcher matchBody = content().json(returnedJSON);
		// test
		myMock.perform(myMockRequest).andExpect(matchStatus).andExpect(matchBody);
	}
}
