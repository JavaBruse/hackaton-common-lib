package com.javabruse.converter;

import com.javabruse.DTO.PhotoTaskDTO;
import com.javabruse.model.Photo;
import com.javabruse.model.Task;
import com.javabruse.repository.PhotoRepo;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class PhotoTaskConverter {
    private final PhotoRepo photoRepo;

    public Photo photoTaskToPhoto(PhotoTaskDTO photoTaskDTO) {
        Optional<Photo> photo = photoRepo.findById(photoTaskDTO.getPhotoID());
        if (photo.isPresent()) {
            Photo newPhoto = photo.get();
            newPhoto.getMetadata().setAddress(photoTaskDTO.getAddress());
            newPhoto.getMetadata().setLatitude(photoTaskDTO.getLatitude());
            newPhoto.getMetadata().setLongitude(photoTaskDTO.getLongitude());
            return newPhoto;
        }
        return new Photo();
    }

    public List<PhotoTaskDTO> taskToPhotoTaskDTOList(Task task) {
        List<PhotoTaskDTO> photoTaskDTOs = new ArrayList<>();
        for (Photo photo : task.getPhotos()) {
            PhotoTaskDTO photoTask = new PhotoTaskDTO();
            photoTask.setId(UUID.randomUUID());
            photoTask.setTaskID(task.getId());
            photoTask.setPhotoID(photo.getId());
            photoTask.setFilePath(photo.getFilePath());
            photoTask.setAddress(photo.getMetadata().getAddress());
            photoTask.setLongitude(photo.getMetadata().getLongitude());
            photoTask.setLatitude(photo.getMetadata().getLatitude());
            photoTaskDTOs.add(photoTask);
        }
        return photoTaskDTOs;
    }
}
