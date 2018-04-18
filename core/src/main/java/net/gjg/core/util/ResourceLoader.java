package net.gjg.core.util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public final class ResourceLoader {

    private ResourceLoader() {

    }

    public static URL getResource(final String resource) {
        URL url ;

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if(classLoader != null){
            url = classLoader.getResource(resource);
            if(url != null){
                return url;
            }
        }

        classLoader = ResourceLoader.class.getClassLoader();
        if(classLoader != null){
            url = classLoader.getResource(resource);
            if(url != null){
                return url;
            }
        }

        return ClassLoader.getSystemResource(resource);
    }

    public static BufferedImage getImageResource(final String resource) throws IOException {
        URL url = getResource(resource);
        return ImageUtils.loadImage(url);
    }
}
