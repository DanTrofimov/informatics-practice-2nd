package ru.itis.trofimoff.ajax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.trofimoff.ajax.models.User;

import java.util.List;

@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAll();

    @Query(value = "select * from users limit ?1 offset ?2", nativeQuery = true)
    List<User> findAllWithPagination(int limit, int offset);

    @Modifying
    void removeById(int id);
}
