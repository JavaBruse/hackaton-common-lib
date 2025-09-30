package com.javabruse.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class PhotoMessage {
    private UUID id;
    private String filePathOriginal;
    private String filePathComplete;
    CamMessage camMessage;
    List<ConstructionMessage> constructionMessageList;

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
