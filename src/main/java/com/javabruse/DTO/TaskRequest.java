package com.javabruse.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class TaskRequest {
    private UUID id;
    private String name;
}

