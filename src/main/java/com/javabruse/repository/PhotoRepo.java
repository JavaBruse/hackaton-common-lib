package com.javabruse.repository;

import com.javabruse.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PhotoRepo extends JpaRepository<Photo, UUID> {
}
