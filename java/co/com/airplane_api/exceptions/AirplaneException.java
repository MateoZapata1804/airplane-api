package co.com.airplane_api.exceptions;

public class AirplaneException extends Exception {

    public AirplaneException() {
        super("Ocurrio un error logico");
    }

    public AirplaneException(String mensaje) {
        super(mensaje);
    }

    public AirplaneException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
