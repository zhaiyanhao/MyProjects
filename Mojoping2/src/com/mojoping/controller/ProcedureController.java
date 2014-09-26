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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mojoping.model.Checklist;
import com.mojoping.model.Procedure;
import com.mojoping.model.ProcedureStep;
import com.mojoping.service.ChecklistService;
import com.mojoping.service.ProcedureService;
import com.mojoping.service.ProcedureStepService;
@Controller
public class ProcedureController {
	
	
	@Autowired
	ChecklistService checklist_service;
	@Autowired
	ProcedureStepService procedurestep_service;
	

	@RequestMapping(value = "/procedurestepAction", method = RequestMethod.POST)
	public String createProcedure(@ModelAttribute("checklist") Checklist checklist,@ModelAttribute("procedurestep") ProcedureStep procedurestep,  
			BindingResult result, Model model, HttpServletRequest request, final RedirectAttributes redirectAttributes) {
		
		
		HttpSession session = request.getSession();
		checklist=(Checklist) session.getAttribute("checklist");
	//	checklist_service.addChecklist(checklist);
	//	System.out.println("              "+checklist.getChecklist_id());
		
		
	//	System.out.println("              "+checklist.getChecklist_id());
		

		
		
		procedurestep.setChecklist_id(checklist.getChecklist_id());
	//	procedure_service.addProcedure(procedure);

		
		System.out.println(checklist.getChecklist_id());
		
		
		int len=procedurestep.getStep_title().split("   ,").length;
		 System.out.println(len);
		 
		 
	   session.setAttribute("procedurestep", procedurestep);
	//   session.setAttribute("checklist", checklist);
	   redirectAttributes.addFlashAttribute("checklist", checklist);
	   redirectAttributes.addFlashAttribute("procedurestep", procedurestep);
	    return "redirect:/material";
	}

}
