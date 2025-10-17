package com.javabruse.converter;

import com.javabruse.DTO.TaskRequest;
import com.javabruse.DTO.TaskResponse;
import com.javabruse.model.Status;
import com.javabruse.model.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class TaskConverter {

    private final PhotoConverter photoConverter;

    public TaskResponse taskToTaskResponse(Task task) {
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setId(task.getId());
        taskResponse.setName(task.getName());
        taskResponse.setStatus(task.getStatus());
        taskResponse.setPhotoCount(task.getPhotos().size());
        taskResponse.setCreatedAt(task.getCreatedAt());
        taskResponse.setUpdatedAt(task.getUpdatedAt());
        return taskResponse;
    }

    public Task taskRequestNew(TaskRequest taskRequest, UUID userId) {
        Task task = new Task();
        task.setName(taskRequest.getName());
        task.setUserId(userId);
        task.setStatus(Status.TASK_NEW);
        task.setPhotos(null);
        return task;
    }

    public Task taskRequestUpdate(TaskRequest taskRequest, Task taskOld) {
        taskOld.setName(taskRequest.getName());
        taskOld.setStatus(Status.TASK_NEW);
        return taskOld;
    }
}
