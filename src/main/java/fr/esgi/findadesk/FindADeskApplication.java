package fr.esgi.findadesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication // same as @Configuration, @EnableAutoConfiguration, @ComponentScan
public class FindADeskApplication 
{
	
	public static void main(String[] args) 
	{
		SpringApplication.run(FindADeskApplication.class, args);
    }
}
