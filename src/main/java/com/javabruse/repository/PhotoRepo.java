package com.javabruse.repository;

import com.javabruse.model.Photo;
import com.javabruse.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PhotoRepo extends JpaRepository<Photo, UUID> {
    List<Photo> findByTaskIdAndUserId(UUID taskId, UUID userId);
    List<Photo> findByUserId(UUID userID);
}
