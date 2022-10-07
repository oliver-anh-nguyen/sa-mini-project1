package edu.miu.sa.miniproject1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StudentInput {
    private String firstName;

    private String lastName;

    private double gpa;

    private int dob;
}
