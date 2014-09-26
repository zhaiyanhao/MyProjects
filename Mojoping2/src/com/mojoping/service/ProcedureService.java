package com.mojoping.service;

import java.util.List;

import com.mojoping.model.Procedure;

public interface ProcedureService {
	
	public void addProcedure(Procedure procedure);
	
	public List<Procedure> listProcedure();
	
	public Procedure getProcedure(Integer procedure_id);
	
	public List<Procedure> getProcedureWithChecklistId(Integer checklist_id);
	
	public void removeProcedure(Integer procedure_id);
}
