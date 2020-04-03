package kiec.ireneusz.spellsandgloryserver.exception;

public class HeroNotFoudException extends AppException {
    private static String NOT_FOUND = "Hero not found";
    private static String NOT_FOUND_ID = "Hero id not found: ";

    public HeroNotFoudException() {
        super(NOT_FOUND);
    }
    public HeroNotFoudException(Long userId) {
        super(NOT_FOUND_ID + userId);
    }

    public HeroNotFoudException(String message) {
        super(message);
    }

    public HeroNotFoudException(Class clazz) {
        super(NOT_FOUND, clazz.getSimpleName().toUpperCase());
    }
}
