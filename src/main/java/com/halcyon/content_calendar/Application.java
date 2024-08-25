package com.halcyon.content_calendar;

import com.halcyon.content_calendar.model.Content;
import com.halcyon.content_calendar.model.Status;
import com.halcyon.content_calendar.model.Type;
import com.halcyon.content_calendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ContentRepository repository) {
		return args -> {
			Content content = new Content(
					null,
					"My inserted data",
					"Inserted data from data loader",
					Status.PUBLISHED,
					Type.COURSE,
					LocalDateTime.of(2024,8,25,12,56),
					null,
					null);

			repository.save(content);
		};
	}

}
