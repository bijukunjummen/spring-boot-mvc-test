package mvctest.domain;
import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Hotel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String address;

	@Column(nullable = false)
	private String zip;

	@Version
	private Long version;

	public Hotel() {
	}

	public Hotel(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return this.name;
	}

	public String getAddress() {
		return this.address;
	}

	public String getZip() {
		return this.zip;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}	
	
	
}