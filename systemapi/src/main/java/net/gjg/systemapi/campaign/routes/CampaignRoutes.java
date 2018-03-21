package net.gjg.systemapi.campaign.routes;

import io.swagger.annotations.ApiOperation;
import net.gjg.systemapi.GjgApplication;
import net.gjg.systemapi.campaign.model.Campaign;
import net.gjg.systemapi.campaign.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = GjgApplication.API_V1)
public class CampaignRoutes {

    private final static String ENDPOINT = "campaign";

    @Autowired
    private CampaignService service;

    @ApiOperation(value = "Get the campaign details",
            nickname = "Get the campaign details",
            notes = "It will retrieve the campaign details")
    @RequestMapping(value = ENDPOINT + "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public HttpEntity<Campaign> getCampaign(@PathVariable Long id) {
        Optional<Campaign> campaign = service.findCampaignById(id);
        if (campaign.isPresent()) {
            return new ResponseEntity<>(campaign.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
