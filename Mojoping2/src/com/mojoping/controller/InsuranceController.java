package com.mojoping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;











import javax.validation.Valid;

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
import com.mojoping.model.Insurance;
import com.mojoping.model.Labor;
import com.mojoping.model.Material;
import com.mojoping.model.Overhead;
import com.mojoping.model.ProcedureStep;
import com.mojoping.model.Profit;
import com.mojoping.model.User;
import com.mojoping.service.ChecklistService;
import com.mojoping.service.GarbageService;
import com.mojoping.service.LaborService;
import com.mojoping.service.MaterialService;
import com.mojoping.service.OverheadService;
import com.mojoping.service.ProcedureService;
import com.mojoping.service.ProcedureStepService;
import com.mojoping.service.ProfitService;
import com.mojoping.service.UserService;
import com.mojoping.service.InsuranceService;
import com.mojoping.session.CurrentUser;


@Controller
public class InsuranceController {
	
	
	@Autowired
	ProcedureService procedure_service;
	

	@Autowired
	ProcedureStepService procedurestep_service;
	
	@Autowired
	MaterialService material_service;
	
	@Autowired
	ChecklistService checklist_service;
	
	@Autowired
	InsuranceService insurance_service;
	
	@Autowired
	LaborService labor_service;
	
	@Autowired
	OverheadService overhead_service;
	
	@Autowired
	ProfitService profit_service;
	
	@Autowired
	GarbageService garbage_service;
	

	


	@RequestMapping(value = "/insuranceAction", method = RequestMethod.POST)
	public String insurancepage(@ModelAttribute("checklist") Checklist checklist,@ModelAttribute("insurance")Insurance insurance,BindingResult result, Model model, HttpServletRequest request, final RedirectAttributes redirectAttributes) {
		
			HttpSession session = request.getSession();
			
			checklist=(Checklist) session.getAttribute("checklist");
			ProcedureStep procedurestep=(ProcedureStep) session.getAttribute("procedurestep");
			Material material=(Material) session.getAttribute("material");
			Labor labor=(Labor) session.getAttribute("labor");
			Overhead overhead=(Overhead) session.getAttribute("overhead");
			Profit profit=(Profit) session.getAttribute("profit");
			Garbage garbage=(Garbage) session.getAttribute("garbage");
			
			String username = new CurrentUser().getCurrentUserName();
			//String username=user.getUsername();
			if(username==null){
				username="anonymousUser";
			}
			checklist.setUsername(username);
			checklist_service.addChecklist(checklist);
			
			int checkid=checklist.getChecklist_id();
			procedurestep.setChecklist_id(checkid);
			material.setProcedure_id(checkid);
			labor.setProcedure_id(checkid);
			overhead.setProcedure_id(checkid);
			profit.setProcedure_id(checkid);
			garbage.setProcedure_id(checkid);
			insurance.setProcedure_id(checkid);
			
			procedurestep_service.addProcedureStep(procedurestep);
			material_service.addMaterial(material);
			labor_service.addLabor(labor);
			overhead_service.addOverhead(overhead);
			profit_service.addProfit(profit);
			garbage_service.addGarbage(garbage);
			insurance_service.addInsurance(insurance);
			
			model.addAttribute("insurance", insurance);
			redirectAttributes.addFlashAttribute("insurance", insurance);
		    return "create_checklist";
		}
		
		
	
	

}
