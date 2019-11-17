package com.wlopera.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wlopera.food.model.FoodDTO;
import com.wlopera.food.service.TypicalFoodApi;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/food")
@Slf4j
public class TypicalFoodController {

	@Autowired
	private TypicalFoodApi service;

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/allFood", method = { RequestMethod.GET }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<FoodDTO> getAllFood() throws Exception {
		log.info("Consultando todos los platos tipicos");
		return service.getFoods();
	}
}
