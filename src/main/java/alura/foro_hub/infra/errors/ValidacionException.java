package alura.foro_hub.infra.errors;

public class ValidacionException extends RuntimeException{

public ValidacionException(String mensaje){
    super(mensaje);
}

}
