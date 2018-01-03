package com.oshcherbak.config;

import com.oshcherbak.client.EntityClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import static com.oshcherbak.config.Constants.*;

@Configuration
@ComponentScan("com.oshcherbak")
public class AppConfig {
    @Bean
    public Jaxb2Marshaller marshaller() throws Exception {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.oshcherbak.soap.api");
        marshaller.afterPropertiesSet();
        return marshaller;
    }

    @Bean
    @Autowired
    public EntityClient entityClient(Jaxb2Marshaller marshaller){
        EntityClient client = new EntityClient();
        client.setDefaultUri(BASE_URI + URI_PORT + MAPPING);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
