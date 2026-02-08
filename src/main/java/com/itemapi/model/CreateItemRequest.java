package com.itemapi.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class CreateItemRequest {

	@NotBlank(message = "Name is required")
	@Size(max = 100, message = "Name cannot be longer than 100 characters")
	private String name;

	@NotBlank(message = "Description is required")
	@Size(max = 500, message = "Description cannot be longer than 500 characters")
	private String description;

	@NotNull(message = "Price is required")
	@PositiveOrZero(message = "Price cannot be negative")
	private Double price;

	@NotBlank(message = "Category is required")
	private String category;

	public CreateItemRequest() {
	}

	// Getters & Setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}