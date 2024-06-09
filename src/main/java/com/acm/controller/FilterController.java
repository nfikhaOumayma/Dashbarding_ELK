package com.acm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acm.entity.Filter;
import com.acm.service.IServiceFilter;

@RestController
@RequestMapping("filters")
@CrossOrigin("*")
public class FilterController {
	@Autowired
	IServiceFilter iserviceFilter;

	@GetMapping("/fetchAll")
	public List<Filter> getAll() {

		return iserviceFilter.getFilters();
	}

	@GetMapping("/fetch/{id}")
	public Filter getOne(@PathVariable("id") Long id) {

		return iserviceFilter.getFilterById(id);
	}

	@PostMapping("/add")
	public Boolean addFilter(@RequestBody Filter filter) {

		return iserviceFilter.createFilter(filter);
	}

	@PutMapping("/update/{id}")
	public Filter updateFilter(@RequestBody Filter filter, @PathVariable("id") Long id) {

		return iserviceFilter.updateFilter(filter, id);
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteFilter(@PathVariable("id") Long id) {

		return iserviceFilter.deleteFilter(id);
	}

}
