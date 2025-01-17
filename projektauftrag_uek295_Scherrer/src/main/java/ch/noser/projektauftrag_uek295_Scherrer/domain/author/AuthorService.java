package ch.noser.projektauftrag_uek295_Scherrer.domain.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repository;

    //Responses with all Authors
    public List<Author> getAuthors() {
        return repository.findAll();
    }

    //Responses with chosen Author
    public Author getAuthor(Integer authorId) throws AuthorNotFoundException {
        return repository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException("Couldn't find product with specified id"));
    }

    //Responses with new, created Author
    public Author createAuthor(Author author) {
        return repository.save(author);
    }

    //Responses with updated Author
    public void updateAuthor(int id, Author author){
        repository.save(author);
    }

    //Responses with response, that Author is deleted
    public void deleteAuthor(Integer authorId) throws NoSuchElementException {
        repository.deleteById(authorId);
    }
}