package com.javabruse.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ConstructionMessage {
    private UUID id;
    private Integer position;
    private String type;
    private String address;
    private Double latitude;
    private Double longitude;

    @Override
    public String toString() {
        return "ConstructionMessage{" +
                "id=" + id +
                ", position=" + position +
                ", type='" + type + '\'' +
                ", address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
