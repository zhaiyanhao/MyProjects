package com.mojoping.service;

import java.util.List;

import com.mojoping.model.Labor;

public interface LaborService {
	public void addLabor(Labor labor);
	
	public List<Labor> listLabor();
	
	public Labor getLabor(Integer labor_id);
	
	public List<Labor> getLaborWithProcedureId(Integer procedure_id);
	
	public void removeLabor(Integer labor_id);

}
