package kiec.ireneusz.spellsandgloryserver.domain.generator;

import kiec.ireneusz.spellsandgloryserver.domain.user.dto.UserApi;
import kiec.ireneusz.spellsandgloryserver.enums.Gender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GeneratorUserService {

    private List<UserApi> userApis = new ArrayList<>();

    List<UserApi> getUserApis(){
        userApis.add(new UserApi(
                Gender.Male,
                "adam@gmail.com",
                "Adam",
                "The best player id this game",
                "adam.png"
        ));
        userApis.add(new UserApi(
                Gender.Female,
                "julia@gmail.com",
                "Julia",
                "The prettiest player id this game",
                "julia.png"
        ));
        userApis.add(new UserApi(
                Gender.Male,
                "krystian@gmail.com",
                "Krystian",
                "The worst player id this game",
                "krystian.png"
        ));
        return userApis;
    }
}
