package com.javabruse.DTO;

import lombok.*;

import java.util.UUID;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskMessage {
    private UUID id;
    private UUID taskID;
    private PhotoMessage photoMessage;

    @Override
    public String toString() {
        return "TaskMessage{" +
                "id=" + id +
                ", taskID=" + taskID +
                ", photoMessage=" + photoMessage +
                '}';
    }
}
