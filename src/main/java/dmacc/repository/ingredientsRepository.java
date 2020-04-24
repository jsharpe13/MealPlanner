package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Ingredients;

@Repository
public interface ingredientsRepository extends JpaRepository<Ingredients,Long>
{

}