package com.javabruse.DTO;


import com.javabruse.model.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Schema(description = "Модель ответа для задачи")
public class TaskResponse {
    @Schema(description = "UUID задачи", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID id;

    @Schema(description = "Название задачи", example = "Обработка фотографий")
    private String name;

    @Schema(description = "Статус задачи", example = "IN_PROGRESS")
    private Status status;

    @Schema(description = "Время создания в миллисекундах", example = "1700000000000")
    private Long createdAt = Instant.now().toEpochMilli();

    @Schema(description = "Время обновления в миллисекундах", example = "1700000000000")
    private Long updatedAt = Instant.now().toEpochMilli();
}
