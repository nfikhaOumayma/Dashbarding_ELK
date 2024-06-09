package com.acm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acm.entity.User;
import com.acm.repository.CollectionRepository;
import com.acm.repository.LoanRepository;
import com.acm.service.IACMService;


@RestController
@RequestMapping("apis")
public class ACMController {
	
	@Autowired
	public IACMService s;
	
	@Autowired
	public LoanRepository lrep;
	@Autowired
	public CollectionRepository crep;

	@GetMapping("/Allindex")
    public String Createindex() {
            s.indexObjects(crep.getCollections(), "acmcollection");
            s.indexObjects(lrep.loanIndex(), "loans");
            return "All the indexes are dreated successfully go to elastic search to check them";
    }
	@GetMapping("/collaborateurs")
    public List<User> getCollaborateurs(@RequestParam String responsableId) {
        return s.findBycollaborateur(responsableId);
    }

	/*@GetMapping("/totalLoans")
	public ResponseEntity<Void> getLoans() {

		s.IndexTotalLoan();
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/collection")
	public ResponseEntity<Void> getCollections() {

		s.IndexCollection();
		return ResponseEntity.ok().build();
	}*/
	
	


}
