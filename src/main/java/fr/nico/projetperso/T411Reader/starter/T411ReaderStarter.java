package fr.nico.projetperso.T411Reader.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("fr.nico.projetperso.*")
@EnableAutoConfiguration
public class T411ReaderStarter {
	public static void main(String[] args) {
		SpringApplication.run(T411ReaderStarter.class, args);
	}
}
