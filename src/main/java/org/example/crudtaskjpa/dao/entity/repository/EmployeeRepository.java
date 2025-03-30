package org.example.crudtaskjpa.dao.entity.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.crudtaskjpa.dao.entity.EmployeeEntity;
import org.example.crudtaskjpa.model.dto.EmployeeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {
     boolean existsByFin(Integer fin);

     @Query(value = "SELECT * FROM employee WHERE fin=?", nativeQuery = true)
     EmployeeEntity findEmployeeByFin(Integer fin);

}
