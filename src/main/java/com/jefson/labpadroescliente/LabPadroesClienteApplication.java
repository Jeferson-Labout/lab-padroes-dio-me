package com.jefson.labpadroescliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@EnableFeignClients
@SpringBootApplication
@OpenAPIDefinition(
		
	info= @Info(title = "Api de Clientes com Integração com ViaCep", version="3.0.1", description="API feita no Santander Bootcamp Fullstack Developer", 
	contact = @Contact(name="Jeferson Labout", email="jefson1989@@gmail.com")),	
		
		servers= {
				@Server(url="http://localhost:8080")
		}
		
		)
public class LabPadroesClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabPadroesClienteApplication.class, args);
	}

}
