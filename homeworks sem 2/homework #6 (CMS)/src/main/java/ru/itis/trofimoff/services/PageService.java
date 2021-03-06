package ru.itis.trofimoff.services;

public interface PageService {
    boolean createFile(String fileName, String fileText);
    public void saveFile(String fileName, String text);
}
