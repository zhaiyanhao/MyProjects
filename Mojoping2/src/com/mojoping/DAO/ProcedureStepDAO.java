package com.mojoping.DAO;

import java.util.List;

import com.mojoping.model.ProcedureStep;

public interface ProcedureStepDAO {

	public void addProcedureStep(ProcedureStep procedurestep);
	
	public List<ProcedureStep> listProcedureStep();
	
	public ProcedureStep getProcedureStep(Integer procedurestep_id);
	
	public List<ProcedureStep> getProcedureStepWithChecklistId(Integer checklist_id);
	
	public void removeProcedureStep(Integer procedurestep_id);
}
