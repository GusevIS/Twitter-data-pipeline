package com.siepam.Collector.collecting.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
//{"venue":{"venue_name":"Online event","lon":179.1962,"lat":-8.521147,"venue_id":26906060},"visibility":"public","response":"yes","guests":0,"member":{"member_id":303287705,"photo":"https:\/\/secure.meetupstatic.com\/photos\/member\/2\/9\/7\/e\/thumb_297790622.jpeg","member_name":"Lee Barnathan"},"rsvp_id":1842895389,"mtime":1593881108907,"event":{"event_name":"Real Networking - Online Edition","event_id":"271462193","time":1594080000000,"event_url":"https:\/\/www.meetup.com\/Powerhouse-Networking-LA\/events\/271462193\/"},"group":{"group_topics":[{"urlkey":"smallbiz","topic_name":"Small Business"},{"urlkey":"networkmarket","topic_name":"Network Marketing"},{"urlkey":"self-improvement","topic_name":"Self-Improvement"},{"urlkey":"prodev","topic_name":"Professional Development"},{"urlkey":"socialnetwork","topic_name":"Social Networking"},{"urlkey":"business","topic_name":"Business"},{"urlkey":"business-referral-networking","topic_name":"Business Referral Networking"},{"urlkey":"women-entrepreneurs","topic_name":"Women Entrepreneurs"},{"urlkey":"professional-networking","topic_name":"Professional Networking"},{"urlkey":"business-strategy","topic_name":"Business Strategy"},{"urlkey":"entrepreneurship","topic_name":"Entrepreneurship"},{"urlkey":"business-entrepreneur-networking","topic_name":"Entrepreneur Networking"},{"urlkey":"startup-businesses","topic_name":"Startup Businesses"}],"group_city":"Los Angeles","group_country":"us","group_id":33395600,"group_name":"Powerhouse Networking - LA","group_lon":-118.4,"group_urlname":"Powerhouse-Networking-LA","group_state":"CA","group_lat":33.96}}
public class MeetupRSVP {
    private Venue venue;
    private String visibility;
    private String response;
    private Long guests;
    private Member member;
    private Long rsvp_id;
    private Long mtime;
    private Event event;
    private Group group;


    @Override
    public String toString() {
        return "{" +
                "\"venue\":" + venue + ',' +
                "\"visibility\":" + visibility + ',' +
                "\"response\":" + response + ',' +
                "\"guests\":" + guests + ',' +
                "\"member\":" + member + ',' +
                "\"rsvp_id\":" + rsvp_id + ',' +
                "\"mtime\":" + mtime + ',' +
                "\"event\":" + event + ',' +
                "\"group\":" + group +
                '}';
    }
}
