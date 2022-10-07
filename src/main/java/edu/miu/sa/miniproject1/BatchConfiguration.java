package edu.miu.sa.miniproject1;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import javax.sql.DataSource;


@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public FlatFileItemReader<StudentInput> reader() {
        return new FlatFileItemReaderBuilder<StudentInput>()
                .name("studentItemReader")
                .resource(new ClassPathResource("student-input.csv"))
                .delimited()
                .names(new String[]{"firstName", "lastName", "gpa", "dob"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<StudentInput>() {{
                    setTargetType(StudentInput.class);
                }})
                .build();
    }

    @Bean
    public StudentItemProcessor processor() {
        return new StudentItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Student> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Student>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO student (first_name, last_name, gpa, dob) VALUES (:firstName, :lastName, :gpa, :dob)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<Student> writer) {
        return stepBuilderFactory.get("step1")
                .<StudentInput, Student> chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }
}
