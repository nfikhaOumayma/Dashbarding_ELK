package com.acm.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "acm_filter")
public class Filter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private long id;

	@Column(name = "field")
	private String field;
	
	@Column(name = "value")
	private String value;
	
	@Column(name = "operation")
	private String operation;
	
	@Column(name = "dateinsert")
	private Date dateinsert;
	
	 @ManyToOne
	    @JoinColumn(name = "kibana_link_id")
	    private KibanaLink kibanaLink;

	public long getId() {
	
		return id;
	}

	public void setId(long id) {
	
		this.id = id;
	}

	public String getField() {
	
		return field;
	}

	public void setField(String field) {
	
		this.field = field;
	}

	public String getValue() {
	
		return value;
	}

	public void setValue(String value) {
	
		this.value = value;
	}

	public String getOperation() {
	
		return operation;
	}

	public void setOperation(String operation) {
	
		this.operation = operation;
	}

	public Date getDateinsert() {
	
		return dateinsert;
	}

	public void setDateinsert(Date dateinsert) {
	
		this.dateinsert = dateinsert;
	}

	public KibanaLink getKibanaLink() {
	
		return kibanaLink;
	}

	public void setKibanaLink(KibanaLink kibanaLink) {
	
		this.kibanaLink = kibanaLink;
	}

	public Filter(long id, String field, String value, String operation, Date dateinsert,
			KibanaLink kibanaLink) {

		super();
		this.id = id;
		this.field = field;
		this.value = value;
		this.operation = operation;
		this.dateinsert = dateinsert;
		this.kibanaLink = kibanaLink;
	}

	public Filter() {

		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {

		return Objects.hash(dateinsert, field, id, kibanaLink, operation, value);
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filter other = (Filter) obj;
		return Objects.equals(dateinsert, other.dateinsert) && Objects.equals(field, other.field)
				&& id == other.id && Objects.equals(kibanaLink, other.kibanaLink)
				&& Objects.equals(operation, other.operation) && Objects.equals(value, other.value);
	}

	@Override
	public String toString() {

		return "Filter [id=" + id + ", field=" + field + ", value=" + value + ", operation="
				+ operation + ", dateinsert=" + dateinsert + ", kibanaLink=" + kibanaLink + "]";
	}


	

}
