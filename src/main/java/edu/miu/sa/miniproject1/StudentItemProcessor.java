package edu.miu.sa.miniproject1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;


public class StudentItemProcessor implements ItemProcessor<StudentInput, Student> {

    private static final Logger log = LoggerFactory.getLogger(StudentItemProcessor.class);

    public Student process(final StudentInput student) throws Exception {

        int dobYear = student.getDob();
        int dobMonth = 01;
        int dobDay = 01;

        LocalDate now = LocalDate.now();
        LocalDate dob = now.minusYears(dobYear)
                .minusMonths(now.getMonth().getValue()-1)
                .minusDays(now.getDayOfMonth()-1);


        final Student transformedStudent = new Student(student.getFirstName(), student.getLastName(), student.getGpa(), dob);
        log.info("Converting (" + student + ") into (" + transformedStudent + ")");
        return transformedStudent;
    }
}
