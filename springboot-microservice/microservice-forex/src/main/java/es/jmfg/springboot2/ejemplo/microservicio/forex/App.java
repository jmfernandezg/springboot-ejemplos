package es.jmfg.springboot2.ejemplo.microservicio.forex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class App {
	// Esta clase inicia la aplicacion y el cliente de discovery
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
