package com.javabruse.converter;

import com.javabruse.DTO.CamMessage;
import com.javabruse.DTO.ConstructionMessage;
import com.javabruse.DTO.PhotoMessage;
import com.javabruse.DTO.TaskMessage;
import com.javabruse.model.CamMetadata;
import com.javabruse.model.ConstructMetadata;
import com.javabruse.model.Photo;
import com.javabruse.model.Task;
import com.javabruse.repository.PhotoRepo;
import com.javabruse.repository.TaskRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class TaskMessageConverter {
    private final PhotoRepo photoRepo;
    private final TaskRepo taskRepo;

    public Photo photoTaskToPhoto(TaskMessage photoTaskDTO) {
        Optional<Photo> photo = photoRepo.findById(photoTaskDTO.getPhotoMessage().getId());
        if (photo.isPresent()) {
            Photo newPhoto = photo.get();
            newPhoto.setTask(taskRepo.findById(photoTaskDTO.getTaskID()).get());
            newPhoto.setUpdatedAt(Instant.now().toEpochMilli());
            newPhoto.setConstructMetadata(toConstructMetaData(photoTaskDTO.getPhotoMessage().getConstructionMessageList()));
            return newPhoto;
        }
        return null;
    }

    public List<TaskMessage> taskToPhotoTaskDTOList(Task task) {
        List<TaskMessage> photoTaskDTOs = new ArrayList<>();
        for (Photo photo : task.getPhotos()) {
            TaskMessage photoTask = new TaskMessage();
            photoTask.setId(UUID.randomUUID());
            photoTask.setTaskID(task.getId());
            photoTask.setPhotoMessage(toPhotoMessage(photo));
            photoTaskDTOs.add(photoTask);
        }
        return photoTaskDTOs;
    }


    private List<ConstructMetadata> toConstructMetaData(List<ConstructionMessage> list){
        List<ConstructMetadata> newList = new ArrayList<>();
        for (ConstructionMessage data:list){
            ConstructMetadata message = new ConstructMetadata();
            message.setAddress(data.getAddress());
            message.setLatitude(data.getLatitude());
            message.setLongitude(data.getLongitude());
            newList.add(message);
        }
        return newList;
    }

    private PhotoMessage toPhotoMessage(Photo photo){
        PhotoMessage photoMessage = new PhotoMessage();
        photoMessage.setId(photo.getId());
        photoMessage.setFilePath(photo.getFilePath());
        photoMessage.setCamMessage(toCamMessage(photo.getCamMetadata()));
        photoMessage.setConstructionMessageList(toConstructionMessageList(photo.getConstructMetadata()));
        return  photoMessage;
    }

    private CamMessage toCamMessage(CamMetadata camMetadata){
        CamMessage camMessage = new CamMessage();
        camMessage.setId(camMetadata.getId());
        camMessage.setAddress(camMetadata.getAddress());
        camMessage.setLatitude(camMetadata.getLatitude());
        camMessage.setLongitude(camMetadata.getLongitude());
        camMessage.setBearing(camMetadata.getBearing());
        camMessage.setElevation(camMetadata.getElevation());
        return  camMessage;
    }

    private List<ConstructionMessage> toConstructionMessageList(List<ConstructMetadata> list){
        List<ConstructionMessage> newList = new ArrayList<>();
        for (ConstructMetadata data:list){
            ConstructionMessage message = new ConstructionMessage();
            message.setAddress(data.getAddress());
            message.setLatitude(data.getLatitude());
            message.setLongitude(data.getLongitude());
            newList.add(message);
        }
        return newList;
    }
}
