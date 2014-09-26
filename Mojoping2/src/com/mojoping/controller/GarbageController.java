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
import com.mojoping.model.Garbage;
import com.mojoping.model.Procedure;
import com.mojoping.service.ChecklistService;
import com.mojoping.service.LaborService;
import com.mojoping.service.ProcedureService;
import com.mojoping.service.UserService;
import com.mojoping.service.GarbageService;


@Controller
public class GarbageController {
	
	
	@Autowired
	ProcedureService procedure_service;
	
	@Autowired
	ChecklistService checklist_service;
	
	@Autowired
	GarbageService garbage_service;

	@RequestMapping(value = "/garbageAction", method = RequestMethod.POST)
	public String garbagepage(@ModelAttribute("checklist") Checklist checklist,@ModelAttribute("garbage")Garbage garbage,BindingResult result, Model model, HttpServletRequest request, final RedirectAttributes redirectAttributes) {
		
			HttpSession session = request.getSession();
			session.setAttribute("garbage", garbage);
			model.addAttribute("garbage", garbage);
			redirectAttributes.addFlashAttribute("garbage", garbage);
			 return "redirect:/insurance";
		}
		
		
	
	

}
