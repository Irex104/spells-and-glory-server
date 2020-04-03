package kiec.ireneusz.spellsandgloryserver.domain.user;

import kiec.ireneusz.spellsandgloryserver.domain.user.dto.HeroApi;
import kiec.ireneusz.spellsandgloryserver.domain.user.dto.HeroUpdateApi;
import kiec.ireneusz.spellsandgloryserver.domain.user.model.Hero;
import kiec.ireneusz.spellsandgloryserver.domain.user.model.User;
import kiec.ireneusz.spellsandgloryserver.exception.HeroNotFoudException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HeroService {

    private final HeroRepository repository;

    @Autowired
    public HeroService(HeroRepository repository) {
        this.repository = repository;
    }


    List<Hero> getAll() {
        return repository.findAllByDeletedAtIsNull().stream()
                .sorted(Comparator.comparing(Hero::getLevel))
                .collect(Collectors.toList());
    }

    Hero getOne(Long heroId) throws HeroNotFoudException {
        return repository.findByIdAndDeletedAtIsNull(heroId)
                .orElseThrow(() -> new HeroNotFoudException(heroId));
    }

    List<Hero> getByName(String name) {
        return repository.findByNameLikeAndDeletedAtIsNull("%"+name+"%").stream()
                .sorted(Comparator.comparing(Hero::getLevel))
                .collect(Collectors.toList());
    }

    List<Hero> getByUser(User user) {
        List<Hero> heroes = repository.findByUserAndDeletedAtIsNull(user);
        return heroes.stream().sorted(Comparator.comparing(Hero::getLevel))
                .collect(Collectors.toList());
    }

    Hero create(User user, HeroApi api) {
        Hero hero = new Hero(user, api);
        return repository.save(hero);
    }

    Hero update(Long heroId, HeroUpdateApi api) throws HeroNotFoudException {
        Hero hero = this.getOne(heroId);
        hero.update(api);
        return repository.save(hero);
    }

    void delete(Long heroId) throws HeroNotFoudException {
        Hero hero = this.getOne(heroId);
        hero.delete();
        repository.save(hero);
    }

    void deleteByUser(User user) {
        List<Hero> heroes = this.getByUser(user);
        repository.saveAll(heroes);
    }
}
