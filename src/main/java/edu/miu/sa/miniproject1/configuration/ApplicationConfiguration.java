package edu.miu.sa.miniproject1.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PreDestroy;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class ApplicationConfiguration {

    private final JdbcTemplate jdbcTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @PreDestroy
    public void onExit() {
        log.info("Cleaning up database....");
        jdbcTemplate.execute("DELETE FROM student");
        jdbcTemplate.execute("DELETE FROM batch_job_execution_params");
        jdbcTemplate.execute("DELETE FROM batch_job_execution_context");
        jdbcTemplate.execute("DELETE FROM batch_step_execution_context");
        jdbcTemplate.execute("DELETE FROM batch_step_execution");
        jdbcTemplate.execute("DELETE FROM batch_job_execution");
        jdbcTemplate.execute("DELETE FROM batch_job_instance");
        log.info("Database cleaned!");
    }
}
