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

    @Override
    public String toString() {
        return "PhotoTaskDTO{" +
                "id=" + id +
                ", taskID=" + taskID +
                ", photoID=" + photoID +
                ", filePath='" + filePath + '\'' +
                ", address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
