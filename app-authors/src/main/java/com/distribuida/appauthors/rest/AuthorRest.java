package com.distribuida.appauthors.rest;

import com.distribuida.appauthors.db.Author;
import com.distribuida.appauthors.repository.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorRest {

    @Autowired
    private AuthorRepository repo;

    @GetMapping
    public List<Author> findAll() {
        System.out.println("findAll");
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Integer id) {
        System.out.println("findById");
        Optional<Author> author = repo.findById(id);
        return author.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Author author) {
        repo.save(author);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Author author, @PathVariable Integer id) {
        Optional<Author> existingAuthor = repo.findById(id);
        if (existingAuthor.isPresent()) {
            Author aut = existingAuthor.get();
            aut.setFirstName(author.getFirstName());
            aut.setLastName(author.getLastName());
            repo.save(aut);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
