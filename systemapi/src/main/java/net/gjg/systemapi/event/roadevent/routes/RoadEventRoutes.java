package net.gjg.systemapi.event.roadevent.routes;

import net.gjg.systemapi.GjgApplication;
import net.gjg.systemapi.event.roadevent.service.RoadEventService;
import net.gjg.systemapi.generated.roadevent.service.GeneratedRoadEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@RequestMapping(value = GjgApplication.API_V1)
public class RoadEventRoutes {

    private final static String ENDPOINT = "roadevent";

    @Autowired
    private RoadEventService service;

    @ResponseBody
    @RequestMapping(
            value = ENDPOINT + "/{text}" + ".png",
            method = RequestMethod.GET,
            produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] generateRoadEvent(@PathVariable String text) throws IOException {
        BufferedImage image = ImageIO.read(getClass().getClassLoader().getResource("road_event/road_event_front.jpg"));
        Graphics graphics = image.getGraphics();
        graphics.setFont(new Font("Arial Black", Font.BOLD, 20));
        graphics.drawString(text, 30, 175);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        return baos.toByteArray();
    }
}
