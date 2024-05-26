package com.acm.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.acm.dto.CalenderEventDTO;
import com.acm.entity.CalendarEvent;



@Repository
public interface CalendarEventRepository extends JpaRepository<CalendarEvent, Long> {

	@Query("SELECT NEW com.acm.dto.CalenderEventDTO( "
			+"ce.id, "
			+ "ce.libelleEvent, "
			+ "ce.statut, " + "ce.dateLastUpdate, " + "ce.dateFin, " + "CASE ce.statut "
			+ "   WHEN 'CLOSED' THEN CASE WHEN DATEDIFF(DAY, ce.dateFin, ce.dateLastUpdate) < 0 THEN 0 ELSE COALESCE(DATEDIFF(DAY, ce.dateFin, ce.dateLastUpdate), 0) END "
			+ "   WHEN 'NEW' THEN CASE WHEN DATEDIFF(DAY, ce.dateFin, CURRENT_DATE()) < 0 THEN 0 ELSE COALESCE(DATEDIFF(DAY, ce.dateFin, CURRENT_DATE()), 0) END "
			+ "END AS retardJour, " + "ce.category, " + "CONCAT(u.nom, ' ', u.prenom) AS owner, "
			+ "u.branchDescription, GETDATE()) " + "FROM CalendarEvent ce "
			+ "INNER JOIN User u ON ce.username = u.username")
	List<CalenderEventDTO> getCalendarEvents();

	
}
