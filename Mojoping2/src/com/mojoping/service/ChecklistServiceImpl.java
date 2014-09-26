package com.mojoping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mojoping.DAO.ChecklistDAO;
import com.mojoping.model.Checklist;

@Service
public class ChecklistServiceImpl implements ChecklistService {

	@Autowired
	ChecklistDAO checklistDAO;
	
	@Transactional
	public void addChecklist(Checklist checklist) {
		checklistDAO.addChecklist(checklist);
	}

	@Transactional
	public List<Checklist> listChecklist() {
		return checklistDAO.listChecklist();
	}

	@Transactional
	public Checklist getChecklistByCategory(Integer category_id) {
		return checklistDAO.getChecklistByCategory(category_id);
	}

	@Transactional
	public Checklist getChecklistBySubCategory(Integer subcategory_id) {
		return checklistDAO.getChecklistBySubCategory(subcategory_id);
	}

	@Transactional
	public List<Checklist> listChecklistByUsername(String username) {
		return checklistDAO.listChecklistByUsername(username);
	}
	
	@Transactional
	public Checklist getChecklistByUsername(String username) {
		return checklistDAO.getChecklistByUsername(username);
	}

	@Transactional
	public void removeChecklist(Integer checklist_id) {
		checklistDAO.removeChecklist(checklist_id);
	}

}
