package ru.itis.trofimoff.services;

import ru.itis.trofimoff.models.Page;

import java.util.List;

public interface PageService {
    boolean createFile(String fileName, String fileText);
    void saveFile(String fileName, String text, Long parentId);
    List<Page> getAllPages();
    Page findPageByName(String name) throws Exception;
    Page findPageByRoute(String route) throws Exception;
}
