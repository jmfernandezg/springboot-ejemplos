package es.jmfg.springboot2.ejemplo.configuracion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
// Shalala ...
public class App {

	// Inicio del app
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication
				.run(App.class, args);

		for (String nombre : applicationContext.getBeanDefinitionNames()) {
			System.out.printf("** []CONF %s%n **", nombre);
		}
	}


	@Profile("dev")
	@Bean
	public String desarrollo() {
		return "dev";
	}

	@Profile("qa")
	@Bean
	public String calidad() {
		return "qa";
	}

	@Profile("prod")
	@Bean
	public String produccion() {
		return "*prod";
	}
}
