package com.mojoping.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.mojoping.model.Chain_entity;
import com.mojoping.model.Category;
import com.mojoping.model.Checklist;
import com.mojoping.model.Confirmation;
import com.mojoping.model.Garbage;
import com.mojoping.model.Insurance;
import com.mojoping.model.Labor;
import com.mojoping.model.Material;
import com.mojoping.model.Overhead;
import com.mojoping.model.ProcedureStep;
import com.mojoping.model.Profit;
import com.mojoping.model.SubCategory;
import com.mojoping.model.User;
import com.mojoping.service.CategoryService;
import com.mojoping.service.ChecklistService;
import com.mojoping.service.GarbageService;
import com.mojoping.service.InsuranceService;
import com.mojoping.service.LaborService;
import com.mojoping.service.MaterialService;
import com.mojoping.service.OverheadService;
import com.mojoping.service.ProcedureService;
import com.mojoping.service.ProcedureStepService;
import com.mojoping.service.ProfitService;
import com.mojoping.service.UserService;
import com.mojoping.session.CurrentUser;

@Controller
public class MainController {
	
	@Autowired
	UserService user_service;
	
	@Autowired
	CategoryService category_service;
	
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
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcomePage(Model model) {
		
	    model.addAttribute("category", new Category()); // the Category object is used as a template to generate the form
	    model.addAttribute("user", new User());
	    
	    return "mojoping";
	}
	
	@RequestMapping(value= "/register", method = RequestMethod.GET)
	public String registerPage(Model model) {
		model.addAttribute("user", new User());
		
		return "register_to_mojoping";
	}
	
	@RequestMapping(value= "/profile", method = RequestMethod.GET)
	public String profilePage(Model model) {		
		String username = new CurrentUser().getCurrentUserName();
		
		if(!username.equals("anonymousUser")){
			User user = user_service.getUser(username);

			String user_profile_pic_path = user.getProfile_pic_path();
			if(user_profile_pic_path == null ){
				String profile_pic_path = "/Mojoping2/resources/images/mojoping_logo.png";
				model.addAttribute("profilePicture", profile_pic_path);
			}else{
				String profile_pic_path = "/Mojoping2/resources/images/" + username + "/" + user_profile_pic_path;
				model.addAttribute("profilePicture", profile_pic_path);
			}			
			
			model.addAttribute("user", user);
		}	
		
		return "profile";
	}
	
	@RequestMapping(value = "/user_confirmation", method = RequestMethod.GET)
	public String userConfirmation(Model model){
		model.addAttribute("confirmation", new Confirmation());

		return "confirmation";
	}

	
	@RequestMapping(value = "/checklists", method = RequestMethod.GET)
	public ModelAndView  checklistsPage() {		
		String username = new CurrentUser().getCurrentUserName();
		Map<String, Object> model = new HashMap<String, Object>();
		
		List<Checklist> myList =checklist_service.listChecklistByUsername(username);
		List<ProcedureStep> procedurestepList =procedurestep_service.listProcedureStep();
		List<Material> materialList =material_service.listMaterial();
		List<Labor> laborList  =labor_service.listLabor();
		
		List<Profit> profitList =profit_service.listProfit();
		List<Overhead> overheadList =overhead_service.listOverhead();
		List<Garbage> garbageList =garbage_service.listGarbage();
		List<Insurance> insuranceList =insurance_service.listInsurance();

		 model.put("checkList", myList);
		 model.put("procedureList", procedurestepList);
		 model.put("materialList", materialList);
		 model.put("laborList", laborList);
		 model.put("profitList", profitList);
		 model.put("overheadList", overheadList);
		 model.put("garbageList", garbageList);
		 model.put("insuranceList", insuranceList);

		 return new ModelAndView("checklists", model);
	    
	}
	
	@RequestMapping(value = "/checklistswithsearch", method = RequestMethod.GET)
	public String checklistsWithSearchPage(@ModelAttribute("category") Category category, Model model) {		
		String username = new CurrentUser().getCurrentUserName();
		
	    model.addAttribute("category", category); 
	    model.addAttribute("user", user_service.getUser(username));
	    
	    return "checklists";
	}
	
	@RequestMapping(value = "/create_checklist", method = RequestMethod.GET)
	public String createChecklist(Model model) {
		model.addAttribute("checklist", new Checklist());
	    model.addAttribute("category", category_service.listCategory());
	    model.addAttribute("subcategory", new SubCategory());
	    
	    return "create_checklist";
	}
	
	@RequestMapping(value = "/procedure", method = RequestMethod.GET)
	public String redirectProcedurePage(@ModelAttribute("checklist") Checklist checklist, Model model) {	
	    model.addAttribute("checklist", checklist);
	    model.addAttribute("procedurestep", new ProcedureStep());
	    
	    return "procedure";
	}
	
	@RequestMapping(value = "/material", method = RequestMethod.GET)
	public String redirectMaterial(@ModelAttribute("checklist") Checklist checklist, Model model) {	
	    model.addAttribute("material", new Material());
	    
	    return "material";
	}
	

@RequestMapping(value = "/labor", method = RequestMethod.GET)
public String redirectLabor(@ModelAttribute("checklist") Checklist checklist, Model model) {	
//	model.addAttribute("checklist", checklist);
    model.addAttribute("labor", new Labor());
    return "labor";
}

@RequestMapping(value = "/overhead", method = RequestMethod.GET)
public String redirectOverhead(@ModelAttribute("checklist") Checklist checklist, Model model) {	
//	model.addAttribute("checklist", checklist);
    model.addAttribute("overhead", new Overhead());
    return "overhead";
}

@RequestMapping(value = "/profit", method = RequestMethod.GET)
public String redirectProfit(@ModelAttribute("checklist") Checklist checklist, Model model) {	
//	model.addAttribute("checklist", checklist);
    model.addAttribute("profit", new Profit());
    return "profit";
}

@RequestMapping(value = "/garbage", method = RequestMethod.GET)
public String redirectGarbage(@ModelAttribute("checklist") Checklist checklist, Model model) {	
//	model.addAttribute("checklist", checklist);
    model.addAttribute("garbage", new Garbage());
    return "garbage";
}

@RequestMapping(value = "/insurance", method = RequestMethod.GET)
public String redirectInsurance(@ModelAttribute("checklist") Checklist checklist, Model model) {	
//	model.addAttribute("checklist", checklist);
    model.addAttribute("insurance", new Insurance());
    return "insurance";
}

}

