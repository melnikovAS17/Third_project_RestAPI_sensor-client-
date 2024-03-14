package ru.melnikov.RestAPI_sensor;

import org.springframework.web.client.RestTemplate;

public class RequestManager {
    public static void main(String[] args) {

        AddMeasurements.addMeasurements(12.24f, false, "TestSensorNameFromClientApp");

        AddSensor.addSensor("TestSensorNameFromClientApp");

        // Получение всех измерений из бд
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/measurements";
        System.out.println(restTemplate.getForObject(url, String.class));
    }
}