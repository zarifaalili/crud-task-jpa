package org.example.crudtaskjpa.dao.entity.repository;

import org.example.crudtaskjpa.dao.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {

}
