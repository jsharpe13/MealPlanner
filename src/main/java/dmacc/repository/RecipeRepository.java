package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Recipes;

@Repository
public interface RecipeRepository extends JpaRepository<Recipes,Long> {

}
