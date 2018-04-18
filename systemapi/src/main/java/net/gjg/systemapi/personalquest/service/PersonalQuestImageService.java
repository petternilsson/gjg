package net.gjg.systemapi.personalquest.service;

import net.gjg.core.util.ImageUtils;
import net.gjg.core.util.ResourceLoader;
import net.gjg.systemapi.personalquest.model.PersonalQuest;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public final class PersonalQuestImageService {

    private PersonalQuestImageService() {

    }
    public static final String FRONT_RESOURCE = "static/images/personal_quest/personal_quest_front.jpg";
    public static final String BACK_RESOURCE = "static/images/personal_quest/personal_quest_back.jpg";

    public static byte[] toImage(PersonalQuest personalQuest) {
        try {
            BufferedImage frontImage = ResourceLoader.getImageResource(FRONT_RESOURCE);
            BufferedImage backImage = ResourceLoader.getImageResource(BACK_RESOURCE);
            frontImage = processFront(frontImage, personalQuest);

            return ImageUtils.toPngByteArray(frontImage);
        } catch (IOException e) {
            //TODO
            throw new RuntimeException(e);
        }
    }

    private static BufferedImage processFront(BufferedImage image, PersonalQuest quest) throws IOException {
        Graphics graphics = image.getGraphics();
        graphics.setFont(new Font("Arial Black", Font.BOLD, 20));
        graphics.drawString(quest.getTitle(), 30, 175);
        return image;
    }

}
