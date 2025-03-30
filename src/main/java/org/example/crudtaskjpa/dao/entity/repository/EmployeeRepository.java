package org.example.crudtaskjpa.dao.entity.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.crudtaskjpa.dao.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {
     boolean existsByFin(Integer fin);
}
