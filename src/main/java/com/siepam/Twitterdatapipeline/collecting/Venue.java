package com.siepam.Twitterdatapipeline.collecting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Venue {
    //{"venue_name":"Beach Sports","lon":153.047272,"lat":-27.406017,"venue_id":24387080}
    private String venue_name;
    private double lon;
    private double lat;
    private long venue_id;

    public Venue() {
    }

    public String getVenue_name() {
        return venue_name;
    }

    public void setVenue_name(String venue_name) {
        this.venue_name = venue_name;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public long getVenue_id() {
        return venue_id;
    }

    public void setVenue_id(long venue_id) {
        this.venue_id = venue_id;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "venue_name='" + venue_name + '\'' +
                ", lon=" + lon +
                ", lat=" + lat +
                ", venue_id=" + venue_id +
                '}';
    }
}
