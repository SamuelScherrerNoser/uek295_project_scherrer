package ch.noser.projektauftrag_uek295_Scherrer.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repository;

    //Responses with all Authors
    public List<Author> getAuthors() {
        return repository.findAll();
    }

    //Responses with chosen Author
    public Author getAuthor(Integer authorId) throws ProductNotFoundException {
        return repository.findById(authorId).orElseThrow(() -> new ProductNotFoundException("Couldn't find product with specified id"));
    }
}