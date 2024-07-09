package com.timestamp.Timestamp.Microservice;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TimestampController {

    @GetMapping("/{date}")
   public Map<String, Object> getTimestamp(@PathVariable String date){
       return generateTimestampResponse(date);

   }

    @GetMapping("/api/timestamp")
    private Map<String, Object> generateTimestampResponse(String date) {
        Map<String, Object> response = new HashMap<>();
        Instant instant;

        try{
            if(date == null) {
                instant = Instant.now();
            }
            else if (date.matches("\\d+")) {
                instant = Instant.ofEpochMilli(Long.parseLong(date));}
            else {
                instant = Instant.parse(date);
            }

            response.put("unix", instant.toEpochMilli());
            response.put("utc", instant.toString());
        } catch (Exception e) {
            response.put("error", "Invalid Date");
        }


        return response;
    }

    public Map<String, Object> getCurrentTimestamp(){
        return generateTimestampResponse(null);
    }
}
