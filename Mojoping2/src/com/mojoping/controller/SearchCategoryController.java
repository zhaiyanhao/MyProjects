package com.mojoping.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mojoping.model.Category;
import com.mojoping.service.CategoryService;
import com.mojoping.service.SubCategoryService;


@Controller
public class SearchCategoryController {
	
	@Autowired	
	private CategoryService category_service;
	
	@Autowired
	private SubCategoryService subcategory_service;	
	
	@RequestMapping(value = "/search_category",  method = RequestMethod.POST)
	public String searchCategoryFromDatabase(@ModelAttribute("category") Category category, Model model, BindingResult result, final RedirectAttributes redirectAttributes){
		
		if(category_service.getCategory(category.getCategory_name()) == null){
			//If there is no category 			
			result.rejectValue("category_name", "error.category", "There is no such category!");
			
			//Send category info back to page
			model.addAttribute("category", category);
			
			return "mojoping";
		}else{			
			redirectAttributes.addFlashAttribute("category", category);
			
			return "redirect:checklistswithsearch";
		}		
	}
	
	@RequestMapping(value = "/getCategories", method = RequestMethod.GET)
	public @ResponseBody List<Category> getCategories(@RequestParam String category_name) {		
		
		return  simulateSearchResult(category_name);
 
	}
	
	private List<Category> simulateSearchResult(String category_name) {
		 
		List<Category> categories =  category_service.listCategory();
		
		List<Category> result = new ArrayList<Category>();
		
		for(int i=0; i<categories.size(); i++){
			if(categories.get(i).getCategory_name().contains(category_name)){
				result.add(categories.get(i));
			}
		}	
 
		return result;
	}
	
}
