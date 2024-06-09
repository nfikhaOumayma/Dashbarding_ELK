package com.acm.service;

import java.util.List;

import com.acm.entity.*;

public interface IServiceFilter {

	public List<Filter> getFilters();
	
	public Filter getFilterById(Long id);
	
	public boolean createFilter(Filter filter);
	
	public Filter updateFilter(Filter filter , Long id);
	
	public Boolean deleteFilter(Long id);
}
