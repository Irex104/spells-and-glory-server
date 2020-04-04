package kiec.ireneusz.spellsandgloryserver.exception;

public class EquipmentNotFoundException extends AppException {
    private static String NOT_FOUND = "Equipment not found";
    private static String NOT_FOUND_ID = "Equipment id not found: ";

    public EquipmentNotFoundException() {
        super(NOT_FOUND);
    }
    public EquipmentNotFoundException(Long userId) {
        super(NOT_FOUND_ID + userId);
    }

    public EquipmentNotFoundException(String message) {
        super(message);
    }

    public EquipmentNotFoundException(Class clazz) {
        super(NOT_FOUND, clazz.getSimpleName().toUpperCase());
    }
}
