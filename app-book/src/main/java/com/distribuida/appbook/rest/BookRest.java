package com.distribuida.appbook.rest;

import com.distribuida.appbook.clients.AuthorRestClient;
import com.distribuida.appbook.db.Book;
import com.distribuida.appbook.dtos.BookDto;
import com.distribuida.appbook.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookRest {

    private final BookRepo br;
    private final AuthorRestClient authorRestClient;

    public BookRest(BookRepo br, AuthorRestClient authorRestClient) {
        this.br = br;
        this.authorRestClient = authorRestClient;
    }

    @GetMapping
    public Flux<BookDto> findAll() {
        return br.findAll()
                .flatMap(book -> authorRestClient.findById(book.getAuthorId())
                        .map(author -> {
                            BookDto dto = new BookDto();
                            dto.setId(book.getId());
                            dto.setTitle(book.getTitle());
                            dto.setIsbn(book.getIsbn());
                            dto.setPrice(book.getPrice());
                            dto.setAuthorName(author.getFirstName());
                            return dto;
                        }));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Book>> findById(@PathVariable Integer id) {
        System.out.println("findID books");
        return br.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Book> create(@RequestBody Book book) {
        book.setId(null);
        return br.save(book);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Void>> update(@RequestBody Book book, @PathVariable Integer id) {
        return br.findById(id)
                .flatMap(existingBook -> {
                    existingBook.setIsbn(book.getIsbn());
                    existingBook.setTitle(book.getTitle());
                    existingBook.setPrice(book.getPrice());
                    existingBook.setAuthorId(book.getAuthorId());
                    return br.save(existingBook);
                })
                .map(updatedBook -> ResponseEntity.ok().<Void>build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Integer id) {
        return br.existsById(id)
                .flatMap(exists -> exists
                        ? br.deleteById(id).then(Mono.just(ResponseEntity.ok().<Void>build()))
                        : Mono.just(ResponseEntity.notFound().<Void>build())
                );
    }
}
