package net.gjg.systemapi.personalquest.service;

import net.gjg.systemapi.common.exception.ResourceNotFoundException;
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
    PersonalQuestRepository repository;

    public List<PersonalQuest> getAllPersonalQuests() {
        return repository.findAll();
    }

    public PersonalQuest getPersonalQuest(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Personal Quest", "id", id));
    }

    public PersonalQuest addPersonalQuest(PersonalQuest personalQuest) {
        LOGGER.error("Personal quest: {}", personalQuest);
        return repository.save(personalQuest);
    }

    public List<byte[]> getPersonalQuestImage(Long id) {
        PersonalQuest quest = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Personal Quest", "id", id));

        throw new ResourceNotFoundException("Personal Quest Image", "id", id);
    }
}
