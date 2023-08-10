package org.jsp.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition (info=@Info(title="Student CRUD",version="1.0",description = "Simple CRUD Operations",contact = @Contact(name="Kavana D M",email="kavanadm05@gmail.com")))
public class DemoApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(DemoApplication.class, args);
	}

}
