package net.gjg.systemapi.personalquest.repository;

import net.gjg.systemapi.personalquest.model.PersonalQuest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalQuestRepository extends JpaRepository<PersonalQuest, Long>{
}
