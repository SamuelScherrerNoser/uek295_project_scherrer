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
    public ResponseEntity<Author> readAuthor(@PathVariable("authorId") Integer authorId) throws AuthorNotFoundException {
        return ResponseEntity.ok().body(service.getAuthor(authorId));
    }

    //POST-Request (new Author)
    @PostMapping
    public void createAuthor(@Valid @RequestBody Author author) {
        service.createAuthor(author);
    }

    //PUT-Request (update)
    @PutMapping("/{authorId}")
    public void updateAuthor(@Valid @PathVariable("authorId") int authorId, @RequestBody Author author) {
        service.updateAuthor(authorId, author);
    }

    //DELETE-Request
    @DeleteMapping("/{authorId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteAuthor(@Valid @PathVariable("authorId") Integer authorId) throws AuthorNotFoundException {
        service.deleteAuthor(authorId);
    }

    //Exceptionhandlers
    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity<String> handleNoSuchElementException(AuthorNotFoundException pnfe) {
        return ResponseEntity.status(404).body(pnfe.getMessage());
    }

}