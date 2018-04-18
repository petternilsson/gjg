package net.gjg.systemapi.personalquest.exception;

import net.gjg.systemapi.common.exception.ResourceNotFoundException;

public class PersonalQuestNotFoundException extends ResourceNotFoundException {
    public PersonalQuestNotFoundException(Long id) {
        super("Personal Quest", "id", id);
    }
}
