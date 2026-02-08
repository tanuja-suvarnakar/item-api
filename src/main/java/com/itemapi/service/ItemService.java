package com.itemapi.service;

import org.springframework.stereotype.Service;

import com.itemapi.model.CreateItemRequest;
import com.itemapi.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ItemService {

	private final List<Item> items = new ArrayList<>();
	private final AtomicLong idCounter = new AtomicLong(1);

	public Item addItem(CreateItemRequest request) {
		Long id = idCounter.getAndIncrement();
		Item item = new Item(id, request.getName(), request.getDescription(), request.getPrice(),
				request.getCategory());
		items.add(item);
		return item;
	}

	public Optional<Item> getItemById(Long id) {
		return items.stream().filter(item -> item.getId().equals(id)).findFirst();
	}
}
