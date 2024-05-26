package com.acm.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "ACM_KibanaLink")
public class KibanaLink  implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private long id;
	
	@Column(name = "link" , columnDefinition = "VARCHAR(MAX)")
	private String link;
	
	@Column(name = "Filter" ,columnDefinition = "VARCHAR(MAX)")
	private String filter;
	
	@Column(name = "dateInsert")
	private Date dateInsert;

	public long getId() {
	
		return id;
	}

	public void setId(long id) {
	
		this.id = id;
	}

	public String getLink() {
	
		return link;
	}

	public void setLink(String link) {
	
		this.link = link;
	}

	public String getFilter() {
	
		return filter;
	}

	public void setFilter(String filter) {
	
		this.filter = filter;
	}

	public Date getDateInsert() {
	
		return dateInsert;
	}

	public void setDateInsert(Date dateInsert) {
	
		this.dateInsert = dateInsert;
	}

	public KibanaLink(long id, String link, String filter, Date dateInsert) {

		super();
		this.id = id;
		this.link = link;
		this.filter = filter;
		this.dateInsert = dateInsert;
	}

	public KibanaLink() {

		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {

		return "KibanaLink [id=" + id + ", link=" + link + ", filter=" + filter + ", dateInsert="
				+ dateInsert + "]";
	}

	@Override
	public int hashCode() {

		return Objects.hash(dateInsert, filter, id, link);
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KibanaLink other = (KibanaLink) obj;
		return Objects.equals(dateInsert, other.dateInsert) && Objects.equals(filter, other.filter)
				&& id == other.id && Objects.equals(link, other.link);
	}

	
	
}
