package com.timestamp.Timestamp.Microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TimestampController {

    @Autowired
    private TimestampService timestampService;

    @GetMapping("/{date}")
    public Map<String, Object> getTimestamp(@PathVariable String date) {
        return timestampService.generateTimestampResponse(date);
    }

    @GetMapping("/api/timestamp")
    public Map<String, Object> getTimestampTwo(@RequestParam(value = "date", required = false) String date) {
        return timestampService.generateTimestampResponse(date);
    }

    @GetMapping("/api/timestamp/now")
    public Map<String, Object> getCurrentTimestamp() {
        return timestampService.generateTimestampResponse(null);
    }
}
