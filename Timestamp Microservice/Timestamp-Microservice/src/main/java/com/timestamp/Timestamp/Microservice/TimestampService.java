package com.timestamp.Timestamp.Microservice;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class TimestampService {

    public Map<String, Object> generateTimestampResponse(String date) {
        Map<String, Object> response = new HashMap<>();
        Instant instant;

        try {
            if (date == null) {
                instant = Instant.now();
            } else if (date.matches("\\d+")) {
                instant = Instant.ofEpochMilli(Long.parseLong(date));
            } else {
                instant = Instant.parse(date);
            }

            response.put("unix", instant.toEpochMilli());
            response.put("utc", instant.toString());
        } catch (Exception e) {
            response.put("error", "Invalid Date");
        }

        return response;
    }
}
