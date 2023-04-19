package ch.noser.projektauftrag_uek295_Scherrer.domain.author;

public class AuthorNotFoundException extends Exception{
    public AuthorNotFoundException(String message){
        super(message);
    }

    public AuthorNotFoundException() {
        super();
    }
}