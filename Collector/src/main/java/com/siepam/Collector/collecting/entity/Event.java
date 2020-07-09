package com.siepam.Collector.collecting.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Event {
    private String event_name;
    private String event_id;
    private Long time;

    @Override
    public String toString() {
        return "{" +
                "\"event_name\":" + event_name + ',' +
                "\"event_id\":" + event_id + ',' +
                "\"time\":" + time +
                '}';
    }
}
