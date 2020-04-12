package dmacc.beans;

import java.util.List;

public class Recipes {
	private long id;
	private String name;
	private String category;
	private List<Ingredients> ingredientsList;
	
	public Recipes() {
		super();
	}
	

	public Recipes(long id, String name, String category, List<Ingredients> ingredientsList) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.ingredientsList = ingredientsList;
	}


	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}


	public List<Ingredients> getIngredientsList() {
		return ingredientsList;
	}


	public void setIngredientsList(List<Ingredients> ingredientsList) {
		this.ingredientsList = ingredientsList;
	}
	
	
}
