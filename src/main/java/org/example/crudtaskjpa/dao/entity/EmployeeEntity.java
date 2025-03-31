package org.example.crudtaskjpa.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "first_name")
    String name;
    @Column(name = "last_name")
    String surname;
    Integer fin;
    Integer age;
    String birthday;
    String phone;
    String email;

}
