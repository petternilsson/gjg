package net.gjg.systemapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GjgApplication {

    public final static String API_V1 = "api/v1/";

    public static void main(String[] args) {
        SpringApplication.run(GjgApplication.class, args);
    }
}
