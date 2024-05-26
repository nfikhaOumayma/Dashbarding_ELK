package com.acm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acm.entity.KibanaLink;
import com.acm.repository.KibanaLinkRepository;

@Service
public class KibanaLinkServiceImpl implements IServiceKibanaLink {

	@Autowired
	KibanaLinkRepository kibanalinkrep;

	@Override
	public List<KibanaLink> getLinks() {

		return kibanalinkrep.findAll();
	}

	@Override
	public KibanaLink getLinkById(Long id) {

		// TODO Auto-generated method stub
		return kibanalinkrep.findById(id).get();
	}

	@Override
	public boolean createKibanaLink(KibanaLink kibanalink) {

		kibanalinkrep.save(kibanalink);
		return true;

	}

	@Override
	public KibanaLink updateKibanaLink(KibanaLink kibanalink, Long id) {
        kibanalink.setId(id);
		kibanalinkrep.save(kibanalink);
		return kibanalinkrep.findById(id).get();
	}

	@Override
	public Boolean deleteKibanaLink(Long id) {

		kibanalinkrep.deleteById(id);
		return !kibanalinkrep.existsById(id);
	}

}
