package com.siepam.Collector.collecting.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Member {
    private Long member_id;
    private String member_name;
    //private String other_services;

    @Override
    public String toString() {
        return "{" +
                "\"member_id\":" + member_id + ',' +
                "\"member_name\":" + member_name +
                '}';
    }
}