package kiec.ireneusz.spellsandgloryserver.exception;

public class UserNotFoundException extends AppException {

    private static String NOT_FOUND = "Player not found";
    private static String NOT_FOUND_ID = "Player id not found: ";

    public UserNotFoundException() {
        super(NOT_FOUND);
    }
    public UserNotFoundException(Long userId) {
        super(NOT_FOUND_ID + userId);
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(Class clazz) {
        super(NOT_FOUND, clazz.getSimpleName().toUpperCase());
    }

}
