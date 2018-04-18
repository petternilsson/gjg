package net.gjg.systemapi.personalquest.service;

import net.gjg.systemapi.personalquest.exception.PersonalQuestNotFoundException;
import net.gjg.systemapi.personalquest.model.PersonalQuest;
import net.gjg.systemapi.personalquest.repository.PersonalQuestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonalQuestService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonalQuestService.class);

    @Autowired
    private PersonalQuestRepository repository;

    public List<PersonalQuest> getAllPersonalQuests() {
        return repository.findAll();
    }

    public PersonalQuest getPersonalQuest(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new PersonalQuestNotFoundException(id));
    }

    public PersonalQuest addPersonalQuest(PersonalQuest personalQuest) {
        LOGGER.info("Adding personal quest {}", personalQuest);
        return repository.save(personalQuest);
    }

    public byte[] getPersonalQuestImage(Long id) {
        PersonalQuest quest = getPersonalQuest(id);
        return PersonalQuestImageService.toImage(quest);
    }

}
