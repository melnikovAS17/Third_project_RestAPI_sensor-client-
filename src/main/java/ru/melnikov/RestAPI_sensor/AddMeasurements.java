package ru.melnikov.RestAPI_sensor;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class AddMeasurements {

    private static final String url = "http://localhost:8080/measurements/add";

    /*
JSON fromat
{
    "temperature" : 3.2,
    "raining": false,
    "sensor" : {
        "name" : "TestSensorNameFromClientApp"
    }
}
    */


    public static void addMeasurements(float temperature, boolean isRaining, String sensorName){
        Map<String, Object> jsonToSend = new HashMap<>();
        jsonToSend.put("temperature", temperature);
        jsonToSend.put("raining", isRaining);
        jsonToSend.put("sensor", Map.of("name", sensorName));

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(jsonToSend);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(url, request, String.class);
    }
}
