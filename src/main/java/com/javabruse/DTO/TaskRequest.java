package com.javabruse.DTO;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.engine.spi.Status;

import java.util.UUID;

@Getter
@Setter
public class TaskRequest {
    private UUID id;
    private String name;
    private Status status;
}

