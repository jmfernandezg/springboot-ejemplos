package es.jmfg.springboot2.ejemplo.rest.swagger.swagger;

import io.swagger.annotations.Contact;
import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(
        info = @Info(
                description = "Ejemplo Rest Swagger API",
                version = "V1.0.0",
                title = "Rest Ejemplo API",
                contact = @Contact(
                   name = "Jose",
                   email = "jmfernandezg@mail.com",
                   url = "https://github.com/jmfernandezg"
                ),
                license = @License(
                   name = "Apache 2.0", 
                   url = "http://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        consumes = {"application/json", "application/xml"},
        produces = {"application/json", "application/xml"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
        externalDocs = @ExternalDocs(value = "Documentacion adicional", url = "http://www.swagger.com")
)
public interface Documentacion {

}