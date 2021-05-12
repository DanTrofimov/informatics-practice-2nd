package ru.itis.trofimoff.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itis.trofimoff.model.Message;

public class Test {
    public static void main(String[] args) throws JsonProcessingException {
        String testJson = "{\"y\":\"0\",\"x\":\"2\"}";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(testJson);

        // get data from request
        System.out.println(actualObj.get("x").asInt());
        System.out.println(actualObj.get("y").asInt());
    }
}
