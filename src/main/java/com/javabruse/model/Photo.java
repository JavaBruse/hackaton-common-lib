package com.javabruse.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "photos", schema = "master_schema")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "file_path")
    private String filePath;// Где хранится фото (локально или ссылка на storage/S3)

    @Column(name = "file_hash", length = 250)  // добавляем поле х
    private String fileHash;

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "updated_at", nullable = false)
    private Long updatedAt = Instant.now().toEpochMilli();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private Task task;

    @OneToOne(mappedBy = "photo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private CamMetadata camMetadata;

    @OneToMany(mappedBy = "photo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ConstructMetadata> constructMetadata = new ArrayList<>();
}
