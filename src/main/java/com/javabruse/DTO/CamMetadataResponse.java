package com.javabruse.DTO;

import lombok.Getter;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;


@Getter
@Setter
@Schema(description = "Метаданные камеры")
public class CamMetadataResponse {
    @Schema(description = "UUID метаданных", example = "123e4567-e89b-12d3-a456-426614174002")
    private UUID id;
    @Schema(description = "Адрес съемки", example = "ул. Примерная, д. 123")
    private String address;
    @Schema(description = "Широта", example = "55.7558")
    private Double latitude;
    @Schema(description = "Долгота", example = "37.6173")
    private Double longitude;
    @Schema(description = "Азимут", example = "45.5")
    private Double bearing;
    @Schema(description = "Высота", example = "120.0")
    private Double elevation;
}
