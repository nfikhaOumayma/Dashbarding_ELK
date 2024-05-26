package com.acm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.acm.entity.User;



@Repository
public interface UserRepository extends JpaRepository<User, String> {
	  @Query(value = "SELECT * FROM ACM_USERS WHERE RESPONSABLE_ID = ?", nativeQuery = true)
	    List<User> findByResponsableId(String responsableId);

}
