package org.example.crudtaskjpa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDto {
    Integer id;
    String name;
    String surname;
    Integer fin;
    Integer age;
    String birthday;
    String phone;
    String email;
}
