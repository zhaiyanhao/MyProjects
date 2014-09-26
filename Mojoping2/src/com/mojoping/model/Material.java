package com.mojoping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity(name="material")
@Table(name="material")
public class Material {

	@Id
	@Column(name="material_id")
	@GeneratedValue
	private Integer material_id;
	
	@Column(name="procedure_id")
	private Integer procedure_id;
	
	@Column(name="material_name")
	private String material_name;
	
	@Column(name="coverage")
	private Integer coverage;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="material_file")
	@Lob
	private byte[] material_file;
	

	public Integer getMaterial_id() {
		return material_id;
	}

	public void setMaterial_id(Integer material_id) {
		this.material_id = material_id;
	}

	public Integer getProcedure_id() {
		return procedure_id;
	}

	public void setProcedure_id(Integer procedure_id) {
		this.procedure_id = procedure_id;
	}

	public String getMaterial_name() {
		return material_name;
	}

	public void setMaterial_name(String material_name) {
		this.material_name = material_name;
	}

	public Integer getCoverage() {
		return coverage;
	}

	public void setCoverage(Integer coverage) {
		this.coverage = coverage;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public byte[] getMaterial_file() {
		return material_file;
	}

	public void setMaterial_file(byte[] material_file) {
		this.material_file = material_file;
	}


	
	
}
