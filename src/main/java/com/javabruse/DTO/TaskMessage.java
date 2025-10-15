package com.javabruse.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;
import lombok.*;

import java.util.UUID;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskMessage {
    @JsonSerialize(using = UUIDSerializer.class)
    @JsonDeserialize(using = UUIDDeserializer.class)
    private UUID id;

    @JsonProperty("taskID")
    @JsonSerialize(using = UUIDSerializer.class)
    @JsonDeserialize(using = UUIDDeserializer.class)
    private UUID taskID;

    @JsonProperty("userID")
    @JsonSerialize(using = UUIDSerializer.class)
    @JsonDeserialize(using = UUIDDeserializer.class)
    private UUID userID;

    @JsonProperty("urldownloads") // ← ВАЖНО: точное соответствие с JSON
    private String URLDownloads;

    @JsonProperty("photoMessage")
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
