package com.acm.service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
	
	@Override
	  public KibanaLink getLastInsertedKibanaLink() {
        List<KibanaLink> kibanaLinks = kibanalinkrep.findTopByOrderByDateInsertDesc();
            return kibanaLinks.get(0);
    }

}
