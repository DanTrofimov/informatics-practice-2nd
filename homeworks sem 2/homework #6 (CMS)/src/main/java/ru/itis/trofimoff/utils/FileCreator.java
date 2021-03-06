package ru.itis.trofimoff.utils;

public interface FileCreator {
    boolean addNewTemplate(String fileName, String fileText);
    String getTextPage(String pageContent);
}
