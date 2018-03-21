package net.gjg.systemapi.campaign.service;

import net.gjg.systemapi.campaign.model.Campaign;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CampaignService {
    public Optional<Campaign> findCampaignById(Long id) {
        return Optional.of(new Campaign("DUMMY NAME"));
    }


}
