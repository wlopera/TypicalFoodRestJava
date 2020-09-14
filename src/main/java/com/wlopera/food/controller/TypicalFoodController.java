package com.wlopera.food.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wlopera.food.controller.model.Food;
import com.wlopera.food.controller.model.FoodCmb;
import com.wlopera.food.model.FoodDTO;
import com.wlopera.food.service.TypicalFoodApi;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/food")
@Slf4j
public class TypicalFoodController {

	@Autowired
	private TypicalFoodApi service;

	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public ModelAndView index() {
		log.info("Cargando la pagina de inicio");

		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("food");

		try {

			modelAndView.addObject("food", getFoodById(2));
			modelAndView.addObject("foodList", getFoodList());

		} catch (Exception e) {
			log.error("##=> Erro consultando data: " + e.getMessage());
			e.printStackTrace();
		}

		return modelAndView;
	}

	@RequestMapping(value = "/foodById",  method = RequestMethod.POST)
  @ResponseBody
	public ModelAndView foodById(Food food) {
		log.info("Consultar plato por identificador: " + food.toString());

		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("food");

		try {

			if (food.getId() == 0) {
				modelAndView.addObject("food", new Food());
			} else  {
				modelAndView.addObject("food", getFoodById(food.getId()));
			}
			
			modelAndView.addObject("foodList", getFoodList());

		} catch (Exception e) {
			log.error("##=> Erro consultando data: " + e.getMessage());
			e.printStackTrace();
		}

		return modelAndView;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/allFood", method = { RequestMethod.GET }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<FoodDTO> getAllFood() throws Exception {
		log.info("Consultando todos los platos tipicos");
		return service.getFoods();
	}

	private List<FoodCmb> getFoodList() {
		List<FoodCmb> foodList = new ArrayList<>();

		foodList.add(new FoodCmb(1, "Pabellón criollo"));
		foodList.add(new FoodCmb(2, "Bandeja paisa"));
		foodList.add(new FoodCmb(3, "Pot au feu [Olla de fuego]"));
		foodList.add(new FoodCmb(4, "Pizza"));
		foodList.add(new FoodCmb(5, "Sushi"));
		foodList.add(new FoodCmb(6, "Taco"));
		foodList.add(new FoodCmb(7, "Hamburguesa"));
		foodList.add(new FoodCmb(8, "Paella"));

		return foodList;

	}

	private Food getFoodById(Integer id) throws Exception {
		FoodDTO foodDto = service.getFoodById(id);

		Food food = new Food();
		
		food.setId(foodDto.getId());
		food.setName(foodDto.getName());
		food.setFrom(foodDto.getFrom());
		food.setIngredients(foodDto.getIngredients());
		food.setImage("/typical/" + foodDto.getImage());
		food.setCharacteristics(foodDto.getCharacteristics());
		food.setDescription(foodDto.getDescription());

		return food;

	}
}
