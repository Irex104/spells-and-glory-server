package kiec.ireneusz.spellsandgloryserver.exception;

public class ItemNotFoundException extends AppException {
    private static String NOT_FOUND = "Item not found";
    private static String NOT_FOUND_ID = "Item id not found: ";

    public ItemNotFoundException() {
        super(NOT_FOUND);
    }
    public ItemNotFoundException(Long itemId) {
        super(NOT_FOUND_ID + itemId);
    }

    public ItemNotFoundException(String message) {
        super(message);
    }

    public ItemNotFoundException(Class clazz) {
        super(NOT_FOUND, clazz.getSimpleName().toUpperCase());
    }
}
