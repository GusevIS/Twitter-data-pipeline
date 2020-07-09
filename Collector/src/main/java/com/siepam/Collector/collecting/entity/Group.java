package com.siepam.Collector.collecting.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Group {
    private GroupTopic[] group_topics;
    private String group_city;
    private String group_country;
    private Long group_id;
    private String group_name;
    private String group_state;

    @Override
    public String toString() {
        return "{" +
                "\"group_topics\":" + Arrays.toString(group_topics) + "," +
                "\"group_city\":" + group_city + ',' +
                "\"group_country\":" + group_country + ',' +
                "\"group_id\":" + group_id + ',' +
                "\"group_name\":" + group_name + ',' +
                "\"group_state\":" + group_state +
                '}';
    }
}
