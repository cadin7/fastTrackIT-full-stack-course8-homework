package ro.fasttrackit.homework8.hotelrooms.server.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String s) {
        super(s);
    }
}
