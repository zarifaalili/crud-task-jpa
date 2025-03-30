package org.example.crudtaskjpa.mapper;

import org.example.crudtaskjpa.dao.entity.EmployeeEntity;
import org.example.crudtaskjpa.model.dto.EmployeeDto;

public class EmployeeMapper {

    public static EmployeeEntity mapToEntity(EmployeeDto dto) {
        EmployeeEntity entity = new EmployeeEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setAge(dto.getAge());
        entity.setBirthday(dto.getBirthday());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        return entity;
    }
    public static EmployeeDto mapToDto(EmployeeEntity entity) {
        EmployeeDto dto = new EmployeeDto();
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setAge(entity.getAge());
        dto.setBirthday(entity.getBirthday());
        dto.setPhone(entity.getPhone());
        dto.setEmail(entity.getEmail());
        return dto;
    }

}
