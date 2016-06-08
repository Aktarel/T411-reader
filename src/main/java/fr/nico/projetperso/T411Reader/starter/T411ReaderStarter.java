package fr.nico.projetperso.T411Reader.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("fr.nico.projetperso.*")
@EnableAutoConfiguration
@SpringBootApplication
public class T411ReaderStarter {
	public static void main(String[] args) {
		SpringApplication.run(T411ReaderStarter.class, args);
	}
}
