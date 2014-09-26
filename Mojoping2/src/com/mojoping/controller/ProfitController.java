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
import com.mojoping.model.Profit;
import com.mojoping.model.Procedure;
import com.mojoping.service.ChecklistService;
import com.mojoping.service.LaborService;
import com.mojoping.service.ProcedureService;
import com.mojoping.service.UserService;
import com.mojoping.service.ProfitService;


@Controller
public class ProfitController {
	
	
	@Autowired
	ProcedureService procedure_service;
	
	@Autowired
	ChecklistService checklist_service;
	
	@Autowired
	ProfitService profit_service;

	@RequestMapping(value = "/profitAction", method = RequestMethod.POST)
	public String profitpage(@ModelAttribute("checklist") Checklist checklist,@ModelAttribute("profit")Profit profit,BindingResult result, Model model, HttpServletRequest request, final RedirectAttributes redirectAttributes) {
		
			HttpSession session = request.getSession();
			session.setAttribute("profit", profit);
			model.addAttribute("profit", profit);
			redirectAttributes.addFlashAttribute("profit", profit);
			 return "redirect:/garbage";
		}
		
		
	
	

}
