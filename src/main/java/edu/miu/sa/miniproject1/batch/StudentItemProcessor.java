package edu.miu.sa.miniproject1.batch;
import edu.miu.sa.miniproject1.dto.StudentDto;
import edu.miu.sa.miniproject1.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import java.time.LocalDate;
import java.time.Month;


@Slf4j
public class StudentItemProcessor implements ItemProcessor<StudentDto, Student> {

    public Student process(final StudentDto studentDto) throws Exception {
        LocalDate dob = LocalDate.of(LocalDate.now().getYear() - studentDto.getAge(), Month.JANUARY, 1);

        final Student transformedStudent = new Student(studentDto.getFirstName(), studentDto.getLastName(), studentDto.getGpa(), dob);
        log.info("Converting (" + studentDto + ") into (" + transformedStudent + ")");
        return transformedStudent;
    }
}
