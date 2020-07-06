package com.siepam.Twitterdatapipeline.collecting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {
    private Venue venue;
    private String visibility;
    private long numOfGuests;

    public Request(){
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public long getNumOfGuests() {
        return numOfGuests;
    }

    public void setNumOfGuests(long numOfGuests) {
        this.numOfGuests = numOfGuests;
    }

    @Override
    public String toString() {
        return "Request{" +
                "venue='" + venue + '\'' +
                "visibility='" + visibility + '\'' +
                ", numOfGuests=" + numOfGuests +
                '}';
    }
}
