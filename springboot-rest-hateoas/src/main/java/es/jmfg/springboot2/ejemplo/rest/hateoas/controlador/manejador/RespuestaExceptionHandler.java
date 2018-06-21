package es.jmfg.springboot2.ejemplo.rest.hateoas.controlador.manejador;

import es.jmfg.springboot2.ejemplo.rest.hateoas.excepcion.TuristaNotFoundException;
import es.jmfg.springboot2.ejemplo.rest.hateoas.modelo.Respuesta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;


@ControllerAdvice
@RestController
public class RespuestaExceptionHandler extends ResponseEntityExceptionHandler {

  // Maneja todas las excepciones
  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Respuesta> manejarTodasLasExcepciones(Exception ex, WebRequest request) {
    Respuesta respuesta = new Respuesta(new Date(), ex.getMessage(),
        request.getDescription(false));
    return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  // Maneja la excepcion TuristaNotFoundException
  @ExceptionHandler(TuristaNotFoundException.class)
  public final ResponseEntity<Respuesta> manejarExcepcionTuristaNoEncontrado(TuristaNotFoundException ex, WebRequest request) {
    Respuesta respuesta = new Respuesta(new Date(), ex.getMessage(),
        request.getDescription(false));
    return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
  }

}