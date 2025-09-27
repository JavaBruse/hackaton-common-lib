package com.javabruse.DTO;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
public class CamMetadataResponse {
    private UUID id;
    private String address;
    private Double latitude;
    private Double longitude;
    private Double bearing;
    private Double elevation;
}
