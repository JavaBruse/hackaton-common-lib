package com.javabruse.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CamMessage {
    private UUID id;
    private String address;
    private Double latitude;
    private Double longitude;
    private Double bearing;
    private Double elevation;

    @Override
    public String toString() {
        return "CamMessage{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", bearing=" + bearing +
                ", elevation=" + elevation +
                '}';
    }
}
