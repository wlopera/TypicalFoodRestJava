package com.wlopera.food.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wlopera.food.model.FoodDTO;

@Service
public class TypicalFoodService implements TypicalFoodApi {

	private static ObjectMapper jsonMapper; // patron sigleton

	@Override
	public List<FoodDTO> getFoods() throws Exception {
		
		if (null == jsonMapper) {
			jsonMapper = new ObjectMapper();
		}
		
		List<FoodDTO> foods = jsonMapper.readValue(new File("src/main/resources/mock-food.json"),
				jsonMapper.getTypeFactory().constructCollectionType(ArrayList.class, FoodDTO.class));
		return foods;	
	}

	@Override
	public FoodDTO getFoodById(Integer id) throws Exception {
		List<FoodDTO> foods = getFoods();
		
		FoodDTO  foodDto = foods.stream().filter(food -> id.equals(food.getId())).findFirst().get();
		System.out.println("##=> Food by ID: " + foodDto);
		return foodDto;
	}
	
	public static void main(String[] args) {
		TypicalFoodService app = new TypicalFoodService();
		
		try {
			System.out.println(app.getFoods());
			
			System.out.println(app.getFoods().get(0).getDescription().get(0));
			System.out.println(app.getFoods().get(0).getDescription().get(1));
			System.out.println(app.getFoods().get(0).getDescription().get(2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
