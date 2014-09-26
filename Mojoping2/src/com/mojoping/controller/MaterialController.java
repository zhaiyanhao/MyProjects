package com.mojoping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mojoping.model.Checklist;
import com.mojoping.model.Material;
import com.mojoping.model.Procedure;
import com.mojoping.service.ChecklistService;
import com.mojoping.service.MaterialService;
import com.mojoping.service.ProcedureService;
import com.mojoping.service.UserService;

@Controller
public class MaterialController {

	@Autowired
	ProcedureService procedure_service;
	
	@Autowired
	ChecklistService checklist_service;
	
	@Autowired
	MaterialService material_service;
	
	@RequestMapping(value = "/materialAction", method = RequestMethod.POST)
	public String materialpage(@ModelAttribute("checklist") Checklist checklist,@ModelAttribute("material")Material material,BindingResult result, Model model, HttpServletRequest request, final RedirectAttributes redirectAttributes) {
		
/*		if(result.hasErrors()){                                        //modelmap
			//Send category and checklist info back to page
			model.addAttribute("material", material);
			
			return "material";
		} else {*/
/*		Checklist checklist;
		Procedure procedure;*/
			HttpSession session = request.getSession();
			//checklist=(Checklist) session.getAttribute("checklist");
			//checklist_service.addChecklist(checklist);
			
			//Procedure procedure=(Procedure) session.getAttribute("procedure");
			//procedure.setChecklist_id(checklist.getChecklist_id());
			//procedure_service.addProcedure(procedure);
			
			//System.out.println("              "+checklist.getChecklist_id());
			
			
			
			//material.setProcedure_id(checklist.getChecklist_id());
			//material.setQuantity(2);
/***************************test***************************************/
		/*	System.out.println(procedure.getProcedure_id());
			System.out.println(material.getCoverage());
			System.out.println(material.getQuantity());*/
			
/******************************************************************/			
			//material_service.addMaterial(material);
			
			session.setAttribute("material", material);
			model.addAttribute("material", material);
			redirectAttributes.addFlashAttribute("material", material);
		    return "redirect:/labor";
		}
		
		
	
	
}
