package de.tekup.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Loan Indicator Service", description = "To check the eligibility of client to have a credit",
contact = @Contact(name = "Hmida Rojbani",email = "hmida.rojbani@tek-up.tn"),version = "1.0"))
public class RestLoanEligBApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestLoanEligBApplication.class, args);
	}

}
