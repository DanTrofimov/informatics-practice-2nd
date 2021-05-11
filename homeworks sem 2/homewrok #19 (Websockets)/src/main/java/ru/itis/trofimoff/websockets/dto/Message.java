package ru.itis.trofimoff.websockets.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Message implements Serializable {
    private int x;
    private int y;
    private String gameStatus;
}
