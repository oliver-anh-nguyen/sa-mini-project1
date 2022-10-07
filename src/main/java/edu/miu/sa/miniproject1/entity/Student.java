package edu.miu.sa.miniproject1.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Student {

    private String firstName;

    private String lastName;

    private double gpa;

    private LocalDate dob;
}
