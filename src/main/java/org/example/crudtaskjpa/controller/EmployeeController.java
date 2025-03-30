package org.example.crudtaskjpa.controller;

import lombok.RequiredArgsConstructor;
import org.example.crudtaskjpa.dao.entity.EmployeeEntity;
import org.example.crudtaskjpa.dao.entity.repository.EmployeeRepository;
import org.example.crudtaskjpa.mapper.EmployeeMapper;
import org.example.crudtaskjpa.model.dto.EmployeeDto;
import org.example.crudtaskjpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa/employee")
@RequiredArgsConstructor
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;


  @PostMapping
  public void createEmployee(@RequestBody EmployeeDto employeeDto){
      employeeService.create(employeeDto);
  }

    @GetMapping
    public List<EmployeeDto> getAllEmployee() {
        List<EmployeeDto> employee = employeeService.getAllEmployee();
        return employee;
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable Integer id){
      EmployeeDto employee=employeeService.getEmployeeById(id);
      return employee;
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable Integer id){
      employeeService.deleteEmployeeById(id);
    }
    @PutMapping("/{id}")
    public EmployeeDto PutupdateEmployee(@PathVariable Integer id, @RequestBody EmployeeDto employeeDto) {
        EmployeeEntity employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        employee.setName(employeeDto.getName());
       employee.setSurname(employeeDto.getSurname());
        employee.setFin(employeeDto.getFin());
       employee.setAge(employeeDto.getAge());
        employee.setBirthday(employeeDto.getBirthday());
        employee.setPhone(employeeDto.getPhone());
        employee.setEmail(employeeDto.getEmail());

        EmployeeEntity updatedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToDto(updatedEmployee);
    }


    @PatchMapping("/{id}")
    public EmployeeDto updatePartialEmployee(@PathVariable Integer id, @RequestBody EmployeeDto employeeDto) {
        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        if (employeeDto.getName() != null) {
            employee.setName(employeeDto.getName());
        }
        if (employeeDto.getSurname() != null) {
            employee.setSurname(employeeDto.getSurname());
        }
        if (employeeDto.getFin() != null) {
            employee.setFin(employeeDto.getFin());
        }
        if (employeeDto.getAge() != null) {
            employee.setAge(employeeDto.getAge());
        }
        if (employeeDto.getBirthday() != null) {
            employee.setBirthday(employeeDto.getBirthday());
        }
        if (employeeDto.getPhone() != null) {
            employee.setPhone(employeeDto.getPhone());
        }
        if (employeeDto.getEmail() != null) {
            employee.setEmail(employeeDto.getEmail());
        }

        EmployeeEntity updatedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToDto(updatedEmployee);
    }
}
