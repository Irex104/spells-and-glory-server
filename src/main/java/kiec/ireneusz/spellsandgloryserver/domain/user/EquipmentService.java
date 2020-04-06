package kiec.ireneusz.spellsandgloryserver.domain.user;

import kiec.ireneusz.spellsandgloryserver.domain.user.model.Equipment;
import kiec.ireneusz.spellsandgloryserver.domain.user.model.Hero;
import kiec.ireneusz.spellsandgloryserver.exception.EquipmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {

    private final EquipmentRepository repository;

    @Autowired
    public EquipmentService(EquipmentRepository repository) {
        this.repository = repository;
    }

    List<Equipment> getAll() {
        return repository.findAllByDeletedAtIsNull();
    }

    Equipment create(Hero hero) {
        Equipment equipment = new Equipment(hero);
        return repository.save(equipment);
    }

    Equipment getByHero(Hero hero) throws EquipmentNotFoundException {
        return repository.findByHeroAndDeletedAtIsNull(hero)
                .orElseThrow(() -> new EquipmentNotFoundException());
    }
}
