package org.example.crudtaskjpa.mapper;

import org.example.crudtaskjpa.dao.entity.EmployeeEntity;
import org.example.crudtaskjpa.model.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDto mapToDto(EmployeeEntity employeeEntity);

    EmployeeEntity mapToEntity(EmployeeDto employeeDto);


}
