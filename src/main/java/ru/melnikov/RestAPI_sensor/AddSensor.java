package ru.melnikov.RestAPI_sensor;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class AddSensor {
    private static final String url = "http://localhost:8080/sensor/registration";

    /*
    JSON format
    {
        "name" : "Sensor name"
    }
    */

    public static void addSensor(String name){
        Map<String, String> jsonToSend = new HashMap<>();
            jsonToSend.put("name", name);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(jsonToSend);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(url, request, String.class);
    }
}
