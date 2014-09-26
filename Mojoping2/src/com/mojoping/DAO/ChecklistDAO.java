package com.mojoping.DAO;

import java.util.List;

import com.mojoping.model.Checklist;

public interface ChecklistDAO {
	
	public void addChecklist(Checklist checklist);
	
	public List<Checklist> listChecklist();
	
	public Checklist getChecklistByCategory(Integer category_id);
	
	public Checklist getChecklistBySubCategory(Integer subcategory_id);
	
	public List<Checklist> listChecklistByUsername(String username);
	
	public Checklist getChecklistByUsername(String username);
	
	public void removeChecklist(Integer checklist_id);
}
