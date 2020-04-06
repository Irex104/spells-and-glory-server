package kiec.ireneusz.spellsandgloryserver.exception;

public class Item2EquipmentNotFoundException extends AppException {
    private static String NOT_FOUND_SLOT = "Not found slot: Equipment Id: ";
    private static String NOT_FOUND_STOL_2 = ", ItemType: ";

    public Item2EquipmentNotFoundException(Long id, String name) {
        super(NOT_FOUND_SLOT + id + NOT_FOUND_STOL_2 + name);
    }

}
