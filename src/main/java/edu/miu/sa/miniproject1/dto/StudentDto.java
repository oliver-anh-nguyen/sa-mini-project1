package edu.miu.sa.miniproject1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private String firstName;

    private String lastName;

    private double gpa;

    private int age;
}