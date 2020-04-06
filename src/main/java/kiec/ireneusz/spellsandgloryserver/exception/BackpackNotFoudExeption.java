package kiec.ireneusz.spellsandgloryserver.exception;

public class BackpackNotFoudExeption extends AppException {
    private static String NOT_FOUND = "Backpack not found";
    private static String NOT_FOUND_ID = "Backpack id not found: ";

    public BackpackNotFoudExeption() {
        super(NOT_FOUND);
    }
    public BackpackNotFoudExeption(Long backpackId) {
        super(NOT_FOUND_ID + backpackId);
    }

    public BackpackNotFoudExeption(String message) {
        super(message);
    }

    public BackpackNotFoudExeption(Class clazz) {
        super(NOT_FOUND, clazz.getSimpleName().toUpperCase());
    }
}
