package com.wlopera.food.controller.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class Food {

	private Integer id;
	private String name;
	private List<String> description;
	private String from;
	private String ingredients;
	private List<String> characteristics;
	private String image;
	
}