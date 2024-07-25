package com.distribuida.appauthors.repository;

import com.distribuida.appauthors.db.Author;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface AuthorRepository extends ReactiveCrudRepository<Author,Integer> {

}
