package com.acm.service;

import java.util.List;

import com.acm.entity.KibanaLink;

public interface IServiceKibanaLink {

	public List<KibanaLink> getLinks();
	
	public KibanaLink getLinkById(Long id);
	
	public boolean createKibanaLink(KibanaLink kibanalink);
	
	public KibanaLink updateKibanaLink(KibanaLink kibanalink , Long id);
	
	public Boolean deleteKibanaLink(Long id);
}
