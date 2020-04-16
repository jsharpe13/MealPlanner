package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.MealPlan;

@Repository
public interface MealPlanRepository extends JpaRepository<MealPlan,Long>
{

}
