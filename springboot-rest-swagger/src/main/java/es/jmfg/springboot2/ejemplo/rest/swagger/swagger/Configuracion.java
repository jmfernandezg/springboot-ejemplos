package es.jmfg.springboot2.ejemplo.rest.swagger.swagger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Configuracion {

  public static final Contact CONTACTO = new Contact(
      "Jose ", "https://github.com/jmfernandezg", "jmfernandezg@mail.com");
    public static final ApiInfo INFORMACION_API = new ApiInfo(
      "Res Api", "Ejemplo Rest Swagger API", "1.0",
      "urn:tos", CONTACTO.getName(),
      "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");

  private static final Set<String> DEFAULT_PRODUCTOR_CONSUMIDOR =
      new HashSet<String>(Arrays.asList("application/json",
          "application/xml"));

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(INFORMACION_API)
        .produces(DEFAULT_PRODUCTOR_CONSUMIDOR)
        .consumes(DEFAULT_PRODUCTOR_CONSUMIDOR);
  }
}