package com.orgofarmsgroup;

import com.orgofarmsgroup.entity.StudentEntity;
import com.orgofarmsgroup.repository.StudentRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class SpringGraphqlValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGraphqlValidationApplication.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner(StudentRepository studentRepository) {
		return args -> {
			studentRepository.save(
					StudentEntity.builder()
							.sid(937L)
							.name("Ram")
							.createdDateTime(new Date())
							.lastUpdatedDateTime(new Date())
							.build()
			);
		};
	}
}
