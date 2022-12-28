package br.com.controleempresarial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class
ControleEmpresarialApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleEmpresarialApplication.class, args);
	}

}
