package com.javabruse.DTO;

import jakarta.persistence.Column;
import lombok.*;

import java.util.UUID;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhotoTaskDTO {
    private UUID id;
    private UUID taskID;
    private UUID photoID;
    private String filePath;
    private String address;
    private Double latitude;
    private Double longitude;
}
