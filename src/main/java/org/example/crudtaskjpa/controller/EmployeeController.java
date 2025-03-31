package org.example.crudtaskjpa.controller;

import lombok.RequiredArgsConstructor;
import org.example.crudtaskjpa.model.EmployeeDto;
import org.example.crudtaskjpa.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public void createEmployee(@RequestBody EmployeeDto employeeDto) {
        employeeService.create(employeeDto);
    }

    @GetMapping
    public List<EmployeeDto> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/fin/{fin}")
    public EmployeeDto getEmployeeByFin(@PathVariable Integer fin) {
        return employeeService.findByFin(fin);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);
    }


    @PutMapping("/{id}")
    public EmployeeDto putupdateEmployee(@PathVariable Integer id, @RequestBody EmployeeDto employeeDto) {
        return employeeService.updateEmployee(id, employeeDto);
    }

    @PatchMapping("/{id}")
    public EmployeeDto updatePartialEmployee(@PathVariable Integer id, @RequestBody EmployeeDto employeeDto) {
        return employeeService.updatePartialEmployee(id, employeeDto);
    }


}
