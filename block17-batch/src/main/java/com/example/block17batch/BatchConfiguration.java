package com.example.block17batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.PathResource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Component
public class BatchConfiguration {

    //We create a file reader with the fields we need, adding the name of the CSV fields, the name of the CSV file
    //itself and some other parameters
    @Bean
    public FlatFileItemReader<Persona> reader() {
        return new FlatFileItemReaderBuilder<Persona>()
                .name("personaItemReader")
                .resource(new PathResource("src/main/resources/people.csv"))
                .delimited()
                //Here we define how to read the info from the resource we've assigned beforehand
                .names(new String[]{"firstName", "lastName"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Persona>() {{
                    setTargetType(Persona.class);
                }})
                .build();
    }

    //We declare the creation of the class PersonaItemProcessor that will transform our names into their uppercase version
    @Bean
    public PersonaItemProcessor processor() {
        return new PersonaItemProcessor();
    }

    //This one creates the query to pass all the data into the database
    //It returns a datatype instead of just executing some code like the other two before this one
    @Bean
    public JdbcBatchItemWriter<Persona> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Persona>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                //Here goes the SQL statement that will interact in this case with our database (PostgreSQL/batch)
                .sql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)")
                .dataSource(dataSource)
                .build();
    }

    //Here we define how the job should behave, in this one, we're creating one where the step 1 is being executed
    //all the time
    @Bean
    public Job importUserJob(JobRepository jobRepository, Step step1) {
        return new JobBuilder("importUserJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                //Here we put the steps that job should take when being executed
                .flow(step1)
                .end()
                .build();
    }

    //Here we define what we are doing with this step that will be executed later inside the job we will assign to
    @Bean
    public Step step1(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager, JdbcBatchItemWriter<Persona> writer) {
        return new StepBuilder("step1", jobRepository)
                .<Persona, Persona> chunk(10, transactionManager)
                //Gets the information from the CSV file
                .reader(reader())
                //Takes the information and modifies it
                .processor(processor())
                //Then takes the information and puts it into the database
                .writer(writer)
                .build();
    }
}
