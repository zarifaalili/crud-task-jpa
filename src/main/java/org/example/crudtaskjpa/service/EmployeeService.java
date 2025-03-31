package org.example.crudtaskjpa.service;

import org.example.crudtaskjpa.dao.entity.EmployeeEntity;
import org.example.crudtaskjpa.dao.repository.EmployeeRepository;
import org.example.crudtaskjpa.exeption.AlreadyExeption;
import org.example.crudtaskjpa.exeption.NotFoundExeption;
import org.example.crudtaskjpa.mapper.EmployeeMapper;
import org.example.crudtaskjpa.model.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public EmployeeDto updateEmployee(Integer id, EmployeeDto employeeDto) {
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
    public EmployeeDto updatePartialEmployee(Integer id, EmployeeDto employeeDto) {
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
    public void create(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = EmployeeMapper.mapToEntity(employeeDto);
        if (employeeRepository.existsByFin(employeeEntity.getFin())) {
            throw new AlreadyExeption("fin unique olmalidir");
        }
        employeeRepository.save(employeeEntity);
    }
    public EmployeeDto getEmployeeById(Integer id) {
        var employeeEntity = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        return EmployeeMapper.mapToDto(employeeEntity);

    }
    public List<EmployeeDto> getAllEmployee() {
        return employeeRepository.findAll().stream().map(EmployeeMapper::mapToDto).toList();
    }

    public void deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
    }
    public EmployeeDto findByFin(Integer fin) {
        EmployeeEntity employeeEntity = employeeRepository.findEmployeeByFin(fin);
        if (employeeEntity == null) {
            throw new NotFoundExeption(fin + " kodlu employee movcud deyil");
        }
        return EmployeeMapper.mapToDto(employeeEntity);
    }
}
