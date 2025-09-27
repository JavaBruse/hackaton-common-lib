package com.javabruse.DTO;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.engine.spi.Status;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class TaskResponse {
    private UUID id;
    private String name;
    private Status status;
    private Long createdAt = Instant.now().toEpochMilli();
    private Long updatedAt = Instant.now().toEpochMilli();
}
