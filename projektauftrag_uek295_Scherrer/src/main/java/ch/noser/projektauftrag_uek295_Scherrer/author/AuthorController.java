package ch.noser.projektauftrag_uek295_Scherrer.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    @Autowired
    private AuthorService service;

    //GET-Request (all Authors)
    @GetMapping
    public ResponseEntity<List<Author>> getAuthor() {
        return ResponseEntity.ok().body(service.getAuthors());
    }

    //GET-Request (chosen Author)
    @GetMapping("/{authorId}")
    public ResponseEntity<Author> getProduct(@PathVariable("authorId") Integer authorId) throws ProductNotFoundException {
        return ResponseEntity.ok().body(service.getAuthor(authorId));
    }

    //POST-Request (new Author)
    @PostMapping
    public ResponseEntity<Author> createProduct(@Valid @RequestBody Author author) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createAuthor(author));
    }

    //DELETE-Request
    @DeleteMapping("/{authorId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteProduct(@Valid @PathVariable("authorId") Integer authorId) throws ProductNotFoundException {
        service.deleteAuthor(authorId);
    }

    //Exceptionhandlers
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleNoSuchElementException(ProductNotFoundException pnfe) {
        return ResponseEntity.status(404).body(pnfe.getMessage());
    }

}