package com.wlopera.food.service;

import java.util.List;

import com.wlopera.food.model.FoodDTO;

public interface TypicalFoodApi {
	
	/**
	 * Consulta todos los platos tipicos existentes actualmente.
	 * 
	 * @return Listado de platos tipicos existentes
	 * 
	 * @throws Exception
	 */
	List<FoodDTO> getFoods() throws Exception;

	/**
	 * Consulta un plato típico por identificador.
	 * 
	 * @param id Identificador a onsultar
	 * 
	 * @return Plato tipicos para ese identificador
	 * 
	 * @throws Exception
	 */
	FoodDTO getFoodById(Integer id) throws Exception;
	
	
}
