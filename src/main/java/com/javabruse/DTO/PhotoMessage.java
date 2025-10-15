package com.javabruse.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class PhotoMessage {
    @JsonSerialize(using = UUIDSerializer.class)
    @JsonDeserialize(using = UUIDDeserializer.class)
    private UUID id;

    private String filePathOriginal;
    private String filePathComplete;

    @JsonProperty("camMessage")
    private CamMessage camMessage;

    @JsonProperty("constructionMessageList")
    private List<ConstructionMessage> constructionMessageList;

    @Override
    public String toString() {
        return "PhotoMessage{" +
                "id=" + id +
                ", filePathOriginal='" + filePathOriginal + '\'' +
                ", filePathComplete='" + filePathComplete + '\'' +
                ", camMessage=" + camMessage +
                ", constructionMessageList=" + constructionMessageList +
                '}';
    }
}
