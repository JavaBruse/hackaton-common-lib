package com.javabruse.repository;

import com.javabruse.model.CamMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CamMetadataRepo extends JpaRepository<CamMetadata, UUID> {
    Optional<CamMetadata> findByPhotoId(UUID photoId);
}
