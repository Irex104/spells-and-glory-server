package kiec.ireneusz.spellsandgloryserver.domain.generator;

import kiec.ireneusz.spellsandgloryserver.domain.user.dto.HeroApi;
import kiec.ireneusz.spellsandgloryserver.enums.Profession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GeneratorHeroService {

    List<HeroApi> heroApis = new ArrayList<>();

    List<HeroApi> getHeroApis(){
        heroApis.add(new HeroApi(
                1L,
                "Baltus",
                "First warrior in this strange world",
                Profession.Warrior,
                "baltus.png"
        ));
        heroApis.add(new HeroApi(
                1L,
                "Argenis",
                "First hunter in this strange world",
                Profession.Hunter,
                "argenis.png"
        ));
        heroApis.add(new HeroApi(
                2L,
                "Meliara",
                "First witch in this strange world",
                Profession.Wizard,
                "meliara.png"
        ));
        heroApis.add(new HeroApi(
                2L,
                "Mertus",
                "Second warrior in this strange world",
                Profession.Warrior,
                "mertus.png"
        ));
        heroApis.add(new HeroApi(
                3L,
                "Aremia",
                "Second hunter in this strange world",
                Profession.Hunter,
                "aremia.png"
        ));
        heroApis.add(new HeroApi(
                3L,
                "Zahras",
                "Second warrior in this strange world",
                Profession.Wizard,
                "zahras.png"
        ));
        return heroApis;
    }

}
