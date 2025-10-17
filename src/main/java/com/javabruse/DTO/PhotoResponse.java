package com.javabruse.DTO;

import com.javabruse.model.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class PhotoResponse {
    private UUID id;
    private String filePathOriginal;
    private String filePathComplete;
    private String fileHash;
    private String name;
    private String contentType;
    private Long fileSize;
    private Status status;
    private Long updatedAt = Instant.now().toEpochMilli();
    private CamMetadataResponse camMetadataResponse;
    private List<ConstructMetadataResponse> constructMetadataResponses = new ArrayList<>();
}
