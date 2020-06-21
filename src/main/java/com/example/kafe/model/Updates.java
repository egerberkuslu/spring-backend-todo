package com.example.kafe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="updates")
public class Updates {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
	private Long id;
 
	@Column(name="name")
    private String name;
	
	@Column(name="version")
    private String version;
	
	@Column(name="describtion")
    private String describtion;

	public Updates(Long id, String name, String version, String describtion) {
		super();
		this.id = id;
		this.name = name;
		this.version = version;
		this.describtion = describtion;
	}

	public Updates() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDescribtion() {
		return describtion;
	}

	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}
    
    
}
