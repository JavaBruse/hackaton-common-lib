package com.javabruse.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PhotoRequest {
    private UUID id;
    private String filePath;
    private UUID taskId;
}
