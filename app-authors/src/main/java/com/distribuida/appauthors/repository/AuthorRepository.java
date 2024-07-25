package com.distribuida.appauthors.repository;

import com.distribuida.appauthors.db.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Transactional
@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
