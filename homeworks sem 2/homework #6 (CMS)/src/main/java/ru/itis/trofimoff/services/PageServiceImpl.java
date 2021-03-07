package ru.itis.trofimoff.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.trofimoff.models.Page;
import ru.itis.trofimoff.repositories.PageRepository;
import ru.itis.trofimoff.utils.FileCreator;

import java.util.List;
import java.util.Optional;

@Service
public class PageServiceImpl implements PageService {

    @Autowired
    private FileCreator fileCreator;

    @Autowired
    private PageRepository pageRepository;

    @Override
    public boolean createFile(String fileName, String fileText) {
        return this.fileCreator.addNewTemplate(fileName, fileText);
    }

    @Override
    public void saveFile(String fileName, String text, Long parentId) {
        String route = "/" + fileName;
        this.pageRepository.savePage(route, text, parentId);
    }

    @Override
    public List<Page> getAllPages() {
        return this.pageRepository.findAll();
    }

    @Override
    public Page findPageByName(String name) throws Exception {
        String route = "/" + name;
        Optional<Page> page = this.pageRepository.findByRoute(route);
        if (page.isPresent()) {
            return page.get();
        } else {
            throw new Exception();
        }
    }

    @Override
    public Page findPageByRoute(String route) throws Exception {
        Optional<Page> page = this.pageRepository.findByRoute(route);
        if (page.isPresent()) {
            return page.get();
        } else {
            throw new Exception();
        }
    }


    /*
        TODO:
            1) Spring генерит статику, ее он увидит только после перезапуска
            2) Сформировать иерархию
     */
}
