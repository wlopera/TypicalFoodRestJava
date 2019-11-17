package com.wlopera.food.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FoodDTO {

	private Integer id;
	private String name;
	private List<String> description;
	private String from;
	private String ingredients;
	private List<String> characteristics;
	private String image;
	
}