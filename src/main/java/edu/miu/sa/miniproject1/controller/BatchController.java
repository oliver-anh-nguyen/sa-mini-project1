package edu.miu.sa.miniproject1.controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class BatchController {
    private final JobLauncher jobLauncher;
    private final Job job;

    @PostMapping( "/admin/batch")
    public Mono<String> triggerBatchJob() {
        log.info("Triggering batch job...");
        JobParameters Parameters = new JobParametersBuilder()
                .addLong("startAt", System.currentTimeMillis()).toJobParameters();
        try {
            jobLauncher.run(job, Parameters);
        } catch (JobExecutionAlreadyRunningException | JobRestartException
                 | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {

            log.error("Batch job failed", e);
            return Mono.fromSupplier(() -> "Batch job failed!");
        }
        log.info("Batch job completed!");
        return Mono.fromSupplier(() -> "Batch job completed!");
    }

}
