package kg.easy.javaspringbootnatv.exceptions;

public class ApiFailException extends RuntimeException {

    public ApiFailException(String message) {
        super(message);
    }

}
