package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dmacc.repository.MealPlanRepository;

@Controller
public class WebController {
	@Autowired
	MealPlanRepository repo;
	
	@GetMapping("viewAllMeals")
	public String viewAllMealPlan(Model model) {
		model.addAttribute("ingrediants", repo.findAll());
		return "mealPlanView";
	}
	

}
