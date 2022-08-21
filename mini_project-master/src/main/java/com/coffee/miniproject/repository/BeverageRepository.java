package com.coffee.miniproject.repository;

import com.coffee.miniproject.model.beverage.Beverage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeverageRepository extends JpaRepository<Beverage, Long> {
}
