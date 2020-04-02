package kiec.ireneusz.spellsandgloryserver.api;

import io.swagger.annotations.Api;
import kiec.ireneusz.spellsandgloryserver.domain.user.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/generators", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Generator")
public class GeneratorController {

    public final UserFacade userFacade;

    @Autowired
    public GeneratorController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }


}
