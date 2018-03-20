package com.walid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        if (args.length != 1) {
            log.error("USAGE: {} http://gturnquist-quoters.cfapps.io/api/random", Application.class.getName());
            System.exit(1);
        }
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(WebEncoder webEncoder) {
        return args -> {
            String encodedResponse = webEncoder.getEncodedResponse(args[0]);
            log.info("Encoded response from URL [{}] is [{}].", args[0], encodedResponse);
        };
    }
}