package com.oshcherbak;

import com.oshcherbak.client.EntityClient;
import com.oshcherbak.config.AppConfig;
import com.oshcherbak.soap.api.GetEntityResponse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class AppRunner {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EntityClient client = (EntityClient) context.getBean(EntityClient.class);

        GetEntityResponse response = client.response(1);
        System.out.println(response.getEntity().toString());
    }
}
