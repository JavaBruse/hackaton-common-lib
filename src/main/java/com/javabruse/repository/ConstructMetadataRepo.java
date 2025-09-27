package com.javabruse.repository;

import com.javabruse.model.ConstructMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConstructMetadataRepo extends JpaRepository<ConstructMetadata, UUID> {
}
