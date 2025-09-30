package com.javabruse.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ConstructMetadataResponse {
    private UUID id;
    private Integer position;
    private String type;
    private String address;
    private Double latitude;
    private Double longitude;

}
