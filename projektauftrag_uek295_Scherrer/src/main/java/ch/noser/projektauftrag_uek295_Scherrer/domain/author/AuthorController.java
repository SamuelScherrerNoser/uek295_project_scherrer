package ch.noser.projektauftrag_uek295_Scherrer.domain.author;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('READ')")
    @Operation(summary = "get all Authors",
               description = "With this endpoint, you get all authors from the database")
    public ResponseEntity<List<Author>> getAuthor() {
        return ResponseEntity.ok().body(service.getAuthors());
    }

    //GET-Request (chosen Author)
    @GetMapping("/{authorId}")
    @PreAuthorize("hasAuthority('READ')")
    @Operation(summary = "get one, specific Author (with ID)",
               description = "With this endpoint, you get one, specific author from the database")
    public ResponseEntity<Author> readAuthor(@PathVariable("authorId") Integer authorId) throws AuthorNotFoundException {
        return ResponseEntity.ok().body(service.getAuthor(authorId));
    }

    //POST-Request (new Author)
    @PostMapping
    @PreAuthorize("hasAuthority('CREATE')")
    @Operation(summary = "create one, specific Author",
               description = "With this endpoint, you create one, specific author. That author will be persisted in the database")
    public void createAuthor(@Valid @RequestBody Author author) {
        service.createAuthor(author);
    }

    //PUT-Request (update)
    @PutMapping("/{authorId}")
    @PreAuthorize("hasAuthority('UPDATE')")
    @Operation(summary = "update one, specific Author",
            description = "With this endpoint, you date one, specific author up. That author will be persisted in the database (updated version)")
    public void updateAuthor(@Valid @PathVariable("authorId") int authorId, @RequestBody Author author) {
        service.updateAuthor(authorId, author);
    }

    //DELETE-Request
    @DeleteMapping("/{authorId}")
    @PreAuthorize("hasAuthority('DELETE')")
    @Operation(summary = "delete one, specific Author",
            description = "With this endpoint, you delete one, specific author. That author will be deleted from the database")
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