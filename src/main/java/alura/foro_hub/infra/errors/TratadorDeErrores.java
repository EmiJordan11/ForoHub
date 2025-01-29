package alura.foro_hub.infra.errors;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErrores {

    //ruta inexistente
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity largarError404(){
        return ResponseEntity.notFound().build();
    }

    //argumentos invalidos con @Valid
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity largarError400(MethodArgumentNotValidException e){
        var errores = e.getFieldErrors().stream()
                .map(ErrorDTO::new).toList();

        return ResponseEntity.badRequest().body(errores);
    }

    @ExceptionHandler(ValidacionException.class)
    public ResponseEntity largarErrorDeValidacion(ValidacionException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }






    //DTO
    public record ErrorDTO(
            String campo,
            String error
    ){
        public ErrorDTO(FieldError e){
            this(e.getField(),e.getDefaultMessage());
        }
    }

}
