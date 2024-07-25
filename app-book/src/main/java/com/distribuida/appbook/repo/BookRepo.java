package com.distribuida.appbook.repo;

import com.distribuida.appbook.db.Book;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BookRepo extends ReactiveCrudRepository<Book, Integer> {

}
