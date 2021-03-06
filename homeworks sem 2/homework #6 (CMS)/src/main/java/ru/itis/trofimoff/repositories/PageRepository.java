package ru.itis.trofimoff.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.trofimoff.models.Page;

public interface PageRepository extends JpaRepository<Page, Long>{
}
