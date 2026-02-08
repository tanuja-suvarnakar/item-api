package com.itemapi.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.itemapi.model.CreateItemRequest;
import com.itemapi.model.Item;
import com.itemapi.service.ItemService;

@RestController
@RequestMapping("/api/items")
public class ItemController {

	private final ItemService itemService;

	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	@PostMapping
	public ResponseEntity<Item> createItem(@Valid @RequestBody CreateItemRequest request) {
		Item createdItem = itemService.addItem(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable Long id) {
		return itemService.getItemById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/health")
	public String health() {
		return "Item API is running";
	}
}