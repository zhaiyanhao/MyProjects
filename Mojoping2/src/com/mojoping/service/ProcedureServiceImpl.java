package com.mojoping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mojoping.DAO.ProcedureDAO;
import com.mojoping.model.Procedure;

@Service
public class ProcedureServiceImpl implements ProcedureService {

	@Autowired
	ProcedureDAO procedureDAO;
	
	@Transactional
	public void addProcedure(Procedure procedure) {
		procedureDAO.addProcedure(procedure);
	}

	@Transactional
	public List<Procedure> listProcedure() {
		return procedureDAO.listProcedure();
	}

	@Transactional
	public Procedure getProcedure(Integer procedure_id) {
		return procedureDAO.getProcedure(procedure_id);
	}

	@Transactional
	public List<Procedure> getProcedureWithChecklistId(Integer checklist_id) {
		return procedureDAO.getProcedureWithChecklistId(checklist_id);
	}

	@Transactional
	public void removeProcedure(Integer procedure_id) {
		procedureDAO.removeProcedure(procedure_id);
	}

}
