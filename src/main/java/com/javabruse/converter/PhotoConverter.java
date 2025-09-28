package com.javabruse.converter;

import com.javabruse.DTO.CamMetadataResponse;
import com.javabruse.DTO.ConstructMetadataResponse;
import com.javabruse.DTO.PhotoRequest;
import com.javabruse.DTO.PhotoResponse;
import com.javabruse.model.CamMetadata;
import com.javabruse.model.ConstructMetadata;
import com.javabruse.model.Photo;
import com.javabruse.model.Task;
import com.javabruse.repository.TaskRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class PhotoConverter {

   private final TaskRepo taskRepo;

    public PhotoResponse PhotoToPhotoResponse(Photo photo){
        PhotoResponse photoResponse = new PhotoResponse();
        photoResponse.setId(photo.getId());

        photoResponse.setFilePath(photo.getFilePath());
        photoResponse.setFileHash(photo.getFileHash());
        photoResponse.setUpdatedAt(photo.getUpdatedAt());
        photoResponse.setName(photo.getName());
        photoResponse.setContentType(photo.getContentType());
        photoResponse.setFileSize(photo.getFileSize());
        if (photo.getCamMetadata() != null) {
            photoResponse.setCamMetadataResponse(camMetadataToResponse(photo.getCamMetadata()));
        }
        if (!photo.getConstructMetadata().isEmpty()){
            photoResponse.setConstructMetadataResponses(constructMetadataToResponse(photo.getConstructMetadata()));
        }
        return photoResponse;
    }

    public Photo photoRequestToNewPhoto(PhotoRequest photoRequest, UUID userId){
            Photo photo = new Photo();
            photo.setId(null);
            photo.setUserId(userId);
            photo.setFilePath(photoRequest.getFilePath());
            photo.setFileHash("hash");
            photo.setName(photoRequest.getName());
            photo.setContentType(photoRequest.getContentType());
            photo.setFileSize(photoRequest.getFileSize());
            Task task = taskRepo.findById(photoRequest.getTaskId()).orElseThrow();
            photo.setTask(task);
//            photo.setCamMetadata(null);
//            photo.setConstructMetadata(new ArrayList<>());
            return photo;
    }

    public Photo photoRequestToUpdatePhoto(PhotoRequest photoRequest, Photo oldPhoto ){
        oldPhoto.setFilePath(photoRequest.getFilePath());
        Task newTask = taskRepo.findById(photoRequest.getTaskId()).orElseThrow();
        if (!oldPhoto.getTask().equals(newTask)) {
            oldPhoto.setTask(newTask);
        }
        return oldPhoto;
    }

    private CamMetadataResponse camMetadataToResponse(CamMetadata camMetadata){
        CamMetadataResponse camMetadataResponse = new CamMetadataResponse();
        camMetadataResponse.setId(camMetadata.getId());
        camMetadataResponse.setAddress(camMetadata.getAddress());
        camMetadataResponse.setLatitude(camMetadata.getLatitude());
        camMetadataResponse.setLongitude(camMetadata.getLongitude());
        camMetadataResponse.setBearing(camMetadata.getBearing());
        camMetadataResponse.setElevation(camMetadata.getElevation());
        return camMetadataResponse;
    }

    private List<ConstructMetadataResponse> constructMetadataToResponse(List<ConstructMetadata> list){
        List<ConstructMetadataResponse> constructMetadataResponses = new ArrayList<>();
        for (ConstructMetadata data: list){
            ConstructMetadataResponse constructMetadataResponse = new ConstructMetadataResponse();
            constructMetadataResponse.setId(data.getId());
            constructMetadataResponse.setType(data.getType());
            constructMetadataResponse.setAddress(data.getAddress());
            constructMetadataResponse.setLongitude(data.getLongitude());
            constructMetadataResponse.setLatitude(data.getLatitude());
            constructMetadataResponses.add(constructMetadataResponse);
        }
        return constructMetadataResponses;
    }
}
