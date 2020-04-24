package dmacc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dmacc.beans.MealPlan;
import dmacc.beans.Recipes;
import dmacc.controller.BeanConfiguration;

@SpringBootApplication
public class MealPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MealPlannerApplication.class, args);
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		
		Recipes r = appContext.getBean("recipe", Recipes.class);
		
		System.out.println(r.toString());
		
		MealPlan m = appContext.getBean("mealPlan", MealPlan.class);
		
		System.out.println(m.toString());
	}

}
