package com.javabruse.repository;

import com.javabruse.model.PhotoMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PhotoMetadataRepo extends JpaRepository<PhotoMetadata, UUID> {
}
