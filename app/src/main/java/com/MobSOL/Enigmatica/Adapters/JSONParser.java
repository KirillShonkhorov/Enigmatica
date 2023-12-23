package com.MobSOL.Enigmatica.Adapters;

import com.MobSOL.Enigmatica.Models.Requests;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONParser {
    public Requests jsonStringToPojo(String JsonString) throws JsonProcessingException {
        return new ObjectMapper().readValue(JsonString,Requests.class);
    }
}
