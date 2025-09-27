package com.javabruse.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class PhotoMessage {
    private UUID id;
    private String filePath;
    CamMessage camMessage;
    List<ConstructionMessage> constructionMessageList;

    @Override
    public String toString() {
        return "PhotoMessage{" +
                "id=" + id +
                ", filePath='" + filePath + '\'' +
                ", camMessage=" + camMessage +
                ", constructionList=" + constructionMessageList +
                '}';
    }
}
