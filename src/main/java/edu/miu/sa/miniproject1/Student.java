package edu.miu.sa.miniproject1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
public class Student {

    private String firstName;

    private String lastName;

    private double gpa;

    private LocalDate dob;

}
