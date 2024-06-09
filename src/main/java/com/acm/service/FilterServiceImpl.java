package com.acm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acm.entity.Filter;
import com.acm.repository.FilterRepository;

@Service
public class FilterServiceImpl implements IServiceFilter {
	@Autowired
	FilterRepository filterRep;

	@Override
	public List<Filter> getFilters() {

		return filterRep.findAll();
	}

	@Override
	public Filter getFilterById(Long id) {

		return filterRep.findById(id).get();
	}

	@Override
	public boolean createFilter(Filter filter) {
		filterRep.save(filter);
		return true;

	}

	@Override
	public Filter updateFilter(Filter filter, Long id) {

		filter.setId(id);
		filterRep.save(filter);
		return filterRep.findById(id).get();
	}

	@Override
	public Boolean deleteFilter(Long id) {
		filterRep.deleteById(id);
		return !filterRep.existsById(id);
	
	}

}
