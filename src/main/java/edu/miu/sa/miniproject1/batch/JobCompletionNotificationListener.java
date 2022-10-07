package edu.miu.sa.miniproject1.batch;
import edu.miu.sa.miniproject1.entity.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
@Slf4j
@RequiredArgsConstructor
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! Time to verify the results");

            jdbcTemplate.query("SELECT first_name, last_name, gpa, dob FROM student",
                    (rs, row) -> new Student(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getDouble(3),
                            rs.getObject(4, LocalDate.class))
            ).forEach(student -> log.info("Found <" + student + "> in the database."));
        }
    }
}
