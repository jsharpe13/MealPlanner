package dmacc.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Recipes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RECIPE_ID")
	private long id;
	@Column(name="NAME")
	private String name;
	@Column(name="CATEGORY")
	private String category;
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable
		(
				name="INGREDIENTS_LIST",
				joinColumns= { @JoinColumn(name="RECIPE_ID", referencedColumnName="RECIPE_ID") },
				inverseJoinColumns= { @JoinColumn(name="INGREDIENT_ID", referencedColumnName="INGREDIENT_ID", unique=true) }
		)
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


	@Override
	public String toString() {
		return "Recipes [id=" + id + ", name=" + name + ", category=" + category + ", ingredientsList="
				+ ingredientsList + "]";
	}
	
	
}