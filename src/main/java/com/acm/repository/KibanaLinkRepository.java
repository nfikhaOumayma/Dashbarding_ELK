package com.acm.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.acm.entity.KibanaLink;

@Repository
public interface KibanaLinkRepository extends JpaRepository<KibanaLink, Long> {
	
	@Query("SELECT k FROM KibanaLink k ORDER BY k.dateInsert DESC")
	List<KibanaLink> findTopByOrderByDateInsertDesc();
}
