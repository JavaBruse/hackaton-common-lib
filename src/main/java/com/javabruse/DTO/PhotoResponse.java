package com.javabruse.DTO;

import com.javabruse.model.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Schema(description = "Модель ответа для фотографии")
public class PhotoResponse {
    @Schema(description = "UUID фотографии", example = "123e4567-e89b-12d3-a456-426614174001")
    private UUID id;
    @Schema(description = "Путь к оригинальному файлу", example = "http://URL_S3/photos/original.jpg")
    private String filePathOriginal;
    @Schema(description = "Путь к обработанному файлу", example = "http://URL_S3/photos/original.jpg")
    private String filePathComplete;
    @Schema(description = "Хэш файла", example = "a1b2c3d4e5f6")
    private String fileHash;
    @Schema(description = "Оригинальне имя фото", example = "photo123.jpg")
    private String name;
    @Schema(description = "MIME-тип файла", example = "image/jpeg")
    private String contentType;
    @Schema(description = "Размер файла в байтах", example = "2048576")
    private Long fileSize;
    @Schema(description = "Статус обработки", example = "COMPLETED")
    private Status status;
    @Schema(description = "Время обновления в миллисекундах", example = "1700000000000")
    private Long updatedAt = Instant.now().toEpochMilli();
    @Schema(description = "Метаданные из фотографии, или далее определенные моделью")
    private CamMetadataResponse camMetadataResponse;
    @Schema(description = "Метаданные сооружений на фото")
    private List<ConstructMetadataResponse> constructMetadataResponses = new ArrayList<>();
}
