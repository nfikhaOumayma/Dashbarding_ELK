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

import com.acm.entity.KibanaLink;
import com.acm.service.IServiceKibanaLink;

@RestController
@RequestMapping("kibanalinks")
@CrossOrigin("*")
public class KibanaLinkController {
	@Autowired
	IServiceKibanaLink iservicekibanalink;

	@GetMapping("/fetchAll")
	public List<KibanaLink> getAll() {

		return iservicekibanalink.getLinks();
	}

	@GetMapping("/fetch/{id}")
	public KibanaLink getOne(@PathVariable("id") Long id) {

		return iservicekibanalink.getLinkById(id);
	}

	@PostMapping("/add")
	public Boolean addKibanaLink(@RequestBody KibanaLink kibanaLink) {

		return iservicekibanalink.createKibanaLink(kibanaLink);
	}

	@PutMapping("/update/{id}")
	public KibanaLink updateKibanaLink(@RequestBody KibanaLink kibanalink,
			@PathVariable("id") Long id) {

		return iservicekibanalink.updateKibanaLink(kibanalink, id);
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteKibanaLink(@PathVariable("id") Long id) {

		return iservicekibanalink.deleteKibanaLink(id);
	}
	
	@GetMapping("/Last")
    public KibanaLink getLastKibanaLink() {
        return iservicekibanalink.getLastInsertedKibanaLink();
    }

}
