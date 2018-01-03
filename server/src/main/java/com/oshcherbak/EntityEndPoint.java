package com.oshcherbak;

import com.oshcherbak.config.Constants;
import com.oshcherbak.repository.EntityRepository;
import com.oshcherbak.soap.api.GetEntityRequest;
import com.oshcherbak.soap.api.GetEntityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import static com.oshcherbak.config.Constants.*;

@Endpoint
public class EntityEndPoint {
    private EntityRepository entityRepository;

    @Autowired
    public EntityEndPoint(EntityRepository entityRepository){
        this.entityRepository = entityRepository;
    }

    @PayloadRoot(namespace = Constants.NAMESPACE_URI, localPart = GET_ENTITY_BY_ID)
    @ResponsePayload
    public GetEntityResponse getEntity(@RequestPayload GetEntityRequest request) {
        GetEntityResponse response = new GetEntityResponse();
        response.setEntity(entityRepository.findCountry(request.getId()));

        return response;
    }

}
