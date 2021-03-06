package ru.itis.trofimoff.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.trofimoff.repositories.PageRepository;
import ru.itis.trofimoff.utils.FileCreator;

@Service
public class PageServiceImpl {

    @Autowired
    private FileCreator fileCreator;

    @Autowired
    private PageRepository pageRepository;

    public PageServiceImpl(FileCreator fileCreator, PageRepository pageRepository) {
        this.fileCreator = fileCreator;
    }

    public boolean createFile(String fileName, String fileText) {
        return this.fileCreator.addNewTemplate(fileName, fileText);
    }

    /*
        TODO:
            1) Spring генерит статику, ее он увидит только после перезапуска
            2) Сформировать иерархию
     */
}
