package org.example;

import io.github.cdimascio.dotenv.Dotenv;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;


public class App {

    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.configure().ignoreIfMalformed().ignoreIfMissing().load();

//        Map<String, Object> configOverrides = new HashMap<>();
//        configOverrides.put("javax.persistence.jdbc.user", dotenv.get("USERNAME"));
//        configOverrides.put("javax.persistence.jdbc.password", dotenv.get("PASSWORD"));

        Map<String, Object> configOverrides = Map.of(
                "javax.persistence.jdbc.user", dotenv.get("USERNAME"),
                "javax.persistence.jdbc.password", dotenv.get("PASSWORD")
        );

        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("Lab4", configOverrides);

        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();


    }

}
