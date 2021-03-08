package ru.itis.trofimoff.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.itis.trofimoff.models.Page;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface PageRepository extends JpaRepository<Page, Long>{
    @Modifying
    @Query(value = "INSERT INTO pages(route, content, parent_id) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void savePage(String route, String content, Long parentId);

    @Query(value = "SELECT * FROM pages", nativeQuery = true)
    List<Page> findAll();

    @Query(value = "SELECT * FROM pages WHERE route = ?1", nativeQuery = true)
    Optional<Page> findByRoute(String route);
}
