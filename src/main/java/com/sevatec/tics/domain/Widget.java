package com.sevatec.tics.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="widgets")
public class Widget implements Serializable {
	private static final long serialVersionUID = 3752178071656705356L;
	
	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	private Long id;	
	
	@Column(name = "type", nullable = false, insertable = true, updatable = false)
	@Length(min = 1, max = 1)
	@NotNull
	private String type;
	
	@Column(name = "name", nullable = false, insertable = true, updatable = true)
	@Length(min = 1, max = 50)
	@NotNull
	private String name;
	
	/**
	 * Constructors.
	 */
	public Widget() {
		
	}
	
	public Widget(String type, String name) {
		this.type = type;
		this.name = name;
	}
	
	/**
	 * Getters/Setters.
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Object equality.
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Widget)) {
			return false;
		}
		Widget that = (Widget) obj;
		EqualsBuilder eb = new EqualsBuilder();
		eb.append(name, that.name);
		return eb.isEquals();
	}

	/**
	 * Object hashcode.
	 */
	@Override
	public int hashCode() {
		HashCodeBuilder hcb = new HashCodeBuilder();
		hcb.append(name);
		return hcb.toHashCode();
	}
}
