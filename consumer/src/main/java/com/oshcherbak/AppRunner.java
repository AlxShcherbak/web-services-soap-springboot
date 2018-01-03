package com.oshcherbak;

import com.oshcherbak.client.EntityClient;
import com.oshcherbak.soap.api.GetEntityResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppRunner {

    public static void main(String[] args) {
        SpringApplication.run(AppRunner.class, args);
    }

    @Bean
    CommandLineRunner lookup(EntityClient entityClient) {
        return args -> {
            GetEntityResponse response = entityClient.response();
            System.err.println(response.getEntity().toString());
        };
    }
}
