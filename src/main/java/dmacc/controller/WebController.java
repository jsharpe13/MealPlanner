package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Recipes;
import dmacc.beans.Ingredients;
import dmacc.repository.RecipeRepository;
import dmacc.repository.ingredientsRepository;

@Controller
public class WebController {
	@Autowired
	RecipeRepository repo;
	ingredientsRepository ingredientsRepo;

	
	@GetMapping("/toMenu")
	public String goToMenu(Model model) 
	{
		return "index";
	}
	@GetMapping("viewAllMeals")
	public String viewAllMealPlan(Model model) 
	{
		model.addAttribute("ingredients", repo.findAll());
		return "mealPlanView";
		
		
	}
	
	@GetMapping("viewAllRecipes")
	public String viewAllRecipes(Model model) {
		model.addAttribute("recipes", repo.findAll());
		return "recipeView";
	}
	
	@GetMapping("/inputRecipe")
	public String addNewRecipe(Model model) {
		Recipes r = new Recipes();
		model.addAttribute("newRecipe", r);
		return "recipeInput";
	}
	

	@GetMapping("/edit/{id}")
	public String showUpdateRecipe(@PathVariable("id") long id, Model model) {
		Recipes r = repo.findById(id).orElse(null);
		System.out.println("RECIPE TO EDIT: " + r.toString());
		model.addAttribute("newRecipe", r);
		return "input";
	}
	
	@PostMapping("/update/{id}")
	public String reviseRecipe(Recipes r, Model model) {
		repo.save(r);
		return viewAllRecipes(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Recipes r = repo.findById(id).orElse(null);
	    repo.delete(r);
	    return viewAllRecipes(model);
	}
	
	
	//--------Ingredients Navigation-----------
	
	@GetMapping("viewAllIngredients")
	public String viewAllIngredients(Model model) 
	{
		if(ingredientsRepo.findAll().isEmpty()) 
		{
			return addNewIngredients(model);
		}
		model.addAttribute("ingredients", ingredientsRepo.findAll());
		return "IngredientsView";
	}
	@GetMapping("/inputIngredient")
	public String addNewIngredients(Model model) 
	{
		Ingredients i = new Ingredients();
		model.addAttribute("newIngredients", i);
		return"inputIngredients";
	}
	@PostMapping("/inputIngredient")
	public String addNewIngredients(@ModelAttribute Ingredients i, Model model) 
	{
		ingredientsRepo.save(i);
		return viewAllIngredients(model);
	}
	@GetMapping("/editIngredients/{id}")
	public String showUpdateIngredients(@PathVariable("id") long id, Model model) 
	{
		Ingredients i = ingredientsRepo.findById(id).orElse(null);
		model.addAttribute("newIngredients", i);
		return "inputIngredients";
	}
	
	@PostMapping("/updateIngredients/{id}")
	public String reviseIngredients(Ingredients i, Model model) 
	{
		ingredientsRepo.save(i);
		return viewAllIngredients(model);
	}
	
	@GetMapping("/deleteIngredients/{id}")
	public String deleteIngredients(@PathVariable("id") long id, Model model) 
	{
		Ingredients i = ingredientsRepo.findById(id).orElse(null);
		ingredientsRepo.delete(i);
		return viewAllIngredients(model);
	}


}