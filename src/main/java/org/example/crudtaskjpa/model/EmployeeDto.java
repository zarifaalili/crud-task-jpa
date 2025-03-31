package org.example.crudtaskjpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class EmployeeDto {
    private Integer id;
    private String name;
    private String surname;
    private Integer fin;
    private Integer age;
    private String birthday;
    private String phone;
    private String email;
}
