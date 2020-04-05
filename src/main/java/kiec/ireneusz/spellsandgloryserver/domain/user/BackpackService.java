package kiec.ireneusz.spellsandgloryserver.domain.user;

import kiec.ireneusz.spellsandgloryserver.domain.user.model.Backpack;
import kiec.ireneusz.spellsandgloryserver.domain.user.model.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BackpackService {

    private final BackpackRepository repository;

    @Autowired
    public BackpackService(BackpackRepository repository) {
        this.repository = repository;
    }

    Backpack create(Hero hero) {
        Backpack backpack = new Backpack(hero);
        return repository.save(backpack);
    }
}
