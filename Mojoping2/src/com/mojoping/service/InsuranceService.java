package com.mojoping.service;

import java.util.List;

import com.mojoping.model.Insurance;

public interface InsuranceService {
	public void addInsurance(Insurance insurance);
	
	public List<Insurance> listInsurance();
	
	public Insurance getInsurance(Integer insurance_id);
	
	public List<Insurance> getInsuranceWithProcedureId(Integer procedure_id);
	
	public void removeInsurance(Integer insurance_id);

}
