package com.siepam.Collector.collecting.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class GroupTopic {
    private String urlkey;
    private String topic_name;

    @Override
    public String toString() {
        return "{" +
                "\"urlkey\":" + urlkey + "," +
                "\"topic_name\":" + topic_name +
                '}';
    }
}
