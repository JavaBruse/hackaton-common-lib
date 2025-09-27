package com.javabruse.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConstructionMessage {
    private String address;
    private Double latitude;
    private Double longitude;

    @Override
    public String toString() {
        return "ConstructionMessage{" +
                "address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
