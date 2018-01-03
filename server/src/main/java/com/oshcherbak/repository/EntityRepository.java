package com.oshcherbak.repository;

import com.oshcherbak.soap.api.Entity;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class EntityRepository {
    private static final Map<Integer, Entity> entities = new HashMap<>();

    @PostConstruct
    public void initData(){
        Entity entity = new Entity();
        entity.setId(0);
        entity.setValue(10);
        entity.setSubvalue("value 0");
        entities.put(entity.getId(), entity);

        entity = new Entity();
        entity.setId(1);
        entity.setValue(11);
        entity.setSubvalue("value 1");
        entities.put(entity.getId(), entity);

        entity = new Entity();
        entity.setId(2);
        entity.setValue(12);
        entity.setSubvalue("value 2");
        entities.put(entity.getId(), entity);

        entity = new Entity();
        entity.setId(3);
        entity.setValue(13);
        entity.setSubvalue("value 3");
        entities.put(entity.getId(), entity);
    }

    public Entity findCountry(Integer id) {
        Assert.notNull(id, "Entity with id = " + id + " id out off repo");
        return entities.get(id);
    }
}
