package com.javabruse.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Schema(description = "Метаданные конструкции")
public class ConstructMetadataResponse {
    @Schema(description = "UUID конструкции", example = "123e4567-e89b-12d3-a456-426614174003")
    private UUID id;
    @Schema(description = "Позиция в списке, описывает сооружение по номеру bbox на фото", example = "1")
    private Integer position;
    @Schema(description = "Тип конструкции", example = "Дом")
    private String type;
    @Schema(description = "Адрес конструкции", example = "ул. Примерная, д. 123")
    private String address;
    @Schema(description = "Широта", example = "55.7558")
    private Double latitude;
    @Schema(description = "Долгота", example = "37.6173")
    private Double longitude;
}
