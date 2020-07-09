package com.siepam.Collector.collecting.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
public class Venue {
    private String venue_name;
    private double lon;
    private double lat;
    private Long venue_id;

    @Override
    public String toString() {
        return "{" +
                "\"venue_name\":" + venue_name + ',' +
                "\"lon\":" + lon + ',' +
                "\"lat\":" + lat + ',' +
                "\"venue_id\":" + venue_id +
                '}';
    }
}
