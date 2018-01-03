package com.oshcherbak.client;

import com.oshcherbak.soap.api.Entity;
import com.oshcherbak.soap.api.GetEntityResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import static com.oshcherbak.config.Constants.*;

public class EntityClient extends WebServiceGatewaySupport{
    public GetEntityResponse response() {
        Entity req = new Entity();
        req.setId(1);
        GetEntityResponse response = (GetEntityResponse) getWebServiceTemplate()
                .marshalSendAndReceive(req,
                        new SoapActionCallback(BASE_URI+URI_PORT+MAPPING));
        return response;
    }
}
