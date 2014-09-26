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
import com.mojoping.model.Labor;

import com.mojoping.model.Procedure;
import com.mojoping.service.ChecklistService;
import com.mojoping.service.LaborService;
import com.mojoping.service.MaterialService;
import com.mojoping.service.ProcedureService;
import com.mojoping.service.UserService;



@Controller
public class LaborController {
	
	
	@Autowired
	ProcedureService procedure_service;
	
	@Autowired
	ChecklistService checklist_service;
	
	@Autowired
	LaborService labor_service;

	@RequestMapping(value = "/laborAction", method = RequestMethod.POST)
	public String laborpage(@ModelAttribute("checklist") Checklist checklist,@ModelAttribute("labor")Labor labor,BindingResult result, Model model, HttpServletRequest request, final RedirectAttributes redirectAttributes) {
		
			HttpSession session = request.getSession();
			session.setAttribute("labor", labor);
			model.addAttribute("labor", labor);
			redirectAttributes.addFlashAttribute("labor", labor);
			 return "redirect:/overhead";
		}
		
		
	
	

}
