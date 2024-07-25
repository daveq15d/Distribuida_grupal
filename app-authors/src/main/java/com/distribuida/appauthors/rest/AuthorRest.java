package com.distribuida.appauthors.rest;

import com.distribuida.appauthors.db.Author;
import com.distribuida.appauthors.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/authors")
public class AuthorRest {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    public Flux<Author> findAll() {
        return authorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Author>> findById(@PathVariable Integer id) {
        return authorRepository.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Author> create(@RequestBody Author author) {
        // Reset the ID to ensure a new entity is created
        author.setId(null);
        return authorRepository.save(author);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Author>> update(@PathVariable Integer id, @RequestBody Author author) {
        return authorRepository.findById(id)
                .flatMap(existingAuthor -> {
                    existingAuthor.setFirstName(author.getFirstName());
                    existingAuthor.setLastName(author.getLastName());
                    return authorRepository.save(existingAuthor);
                })
                .map(updatedAuthor -> new ResponseEntity<>(updatedAuthor, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Integer id) {
        return authorRepository.findById(id)
                .flatMap(existingAuthor ->
                        authorRepository.delete(existingAuthor)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
