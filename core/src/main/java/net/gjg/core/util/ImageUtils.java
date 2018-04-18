package net.gjg.core.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

public final class ImageUtils {
    private ImageUtils() {

    }

    public static BufferedImage loadImage(final URL url) throws IOException {
        return ImageIO.read(url);
    }

    public static byte[] toPngByteArray(BufferedImage image) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        return baos.toByteArray();
    }
}
