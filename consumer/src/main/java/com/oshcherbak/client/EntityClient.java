package com.oshcherbak.client;

import com.oshcherbak.soap.api.GetEntityRequest;
import com.oshcherbak.soap.api.GetEntityResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import static com.oshcherbak.config.Constants.*;

public class EntityClient extends WebServiceGatewaySupport{
    public GetEntityResponse response(int lookedId) {
        GetEntityRequest req = new GetEntityRequest();
        req.setId(lookedId);
        GetEntityResponse response = (GetEntityResponse) getWebServiceTemplate()
                .marshalSendAndReceive(req,
                        new SoapActionCallback(BASE_URI+MAPPING));
        return response;
    }
}
