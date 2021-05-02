package ru.itis.trofimoff.websockets.dto;

import lombok.Data;

@Data
public class Message {
    private String text;
    private String from;
}
