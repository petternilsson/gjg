package net.gjg.systemapi.personalquest.routes;

import io.swagger.annotations.ApiOperation;
import net.gjg.systemapi.GjgApplication;
import net.gjg.systemapi.personalquest.model.PersonalQuest;
import net.gjg.systemapi.personalquest.service.PersonalQuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.validation.Valid;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;


@RestController
@RequestMapping(value = GjgApplication.API_V1)
public class PersonalQuestRoutes {

    private static final String ENDPOINT = "/personalquests";

    @Autowired
    private PersonalQuestService service;

    @ApiOperation(value = "Get all personal quests",
            nickname = "Get all personal quests",
            notes = "It will retrieve all personal quests")
    @GetMapping(value = ENDPOINT)
    @ResponseBody
    public List<PersonalQuest> getAllPersonalQuests() {
        return service.getAllPersonalQuests();
    }

    @ApiOperation(value = "Get the personal quest details",
            nickname = "Get the personal quest details",
            notes = "It will retrieve the campaign details")
    @GetMapping(ENDPOINT + "/{id}")
    @ResponseBody
    public PersonalQuest getPersonalQuest(@PathVariable Long id) {
        return service.getPersonalQuest(id);
    }

    @ApiOperation(value = "Get the image representation of a personal quest",
            nickname = "Get the image representation of a personal quest",
            notes = "Will return the image representation of a personal quest")
    @RequestMapping(
            value = ENDPOINT + "/{id}" + ".png",
            method = RequestMethod.GET,
            produces = MediaType.IMAGE_PNG_VALUE
    )
    @ResponseBody
    public byte[] getPersonalQuestImage(@PathVariable Long id) {
        return service.getPersonalQuestImage(id);
    }

    @ApiOperation(value = "Get the image representation of a personal quest",
            nickname = "Get the image representation of a personal quest",
            notes = "Will return the image representation of a personal quest")
    @RequestMapping(value = ENDPOINT, method = RequestMethod.POST)
    @ResponseBody
    public PersonalQuest createPersonalQuest(@Valid @RequestBody PersonalQuest personalQuest) {
        return service.addPersonalQuest(personalQuest);
    }

}