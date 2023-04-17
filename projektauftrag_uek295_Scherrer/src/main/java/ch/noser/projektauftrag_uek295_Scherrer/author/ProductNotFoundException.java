package ch.noser.projektauftrag_uek295_Scherrer.author;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(String message){
        super(message);
    }

    public ProductNotFoundException() {
        super();
    }
}