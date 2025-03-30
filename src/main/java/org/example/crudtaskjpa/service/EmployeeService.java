package org.example.crudtaskjpa.service;

import org.example.crudtaskjpa.dao.entity.EmployeeEntity;
import org.example.crudtaskjpa.dao.entity.repository.EmployeeRepository;
import org.example.crudtaskjpa.mapper.EmployeeMapper;
import org.example.crudtaskjpa.model.dto.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;

  public void create(EmployeeDto employeeDto){
      EmployeeEntity employeeEntity= EmployeeMapper.mapToEntity(employeeDto);
      employeeRepository.save(employeeEntity);
  }

  public EmployeeDto getEmployeeById(Integer id){
      var employeeEntity=employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

      return EmployeeMapper.mapToDto(employeeEntity);

  }


  public List<EmployeeDto> getAllEmployee(){

      return employeeRepository.findAll().stream().map(EmployeeMapper::mapToDto).toList();
  }


  public  void deleteEmployeeById(Integer id){
      employeeRepository.deleteById(id);
  }
}
