package org;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable {
    private String author;
    private String title;
    private String isbn;

    public Book(String author, String title, String isbn){
        this.author = author;
        this.title = title;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int hashCode(){
        return Objects.hash(author, title, isbn);

    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        Book other = (Book) obj;
        return this.title.equalsIgnoreCase(other.title) && this.author.equalsIgnoreCase(other.author) && this.isbn.equalsIgnoreCase(other.isbn) ;
    }

    @Override
    public String toString(){
        return this.author + " " + this.title + " " + this.isbn;
    }

}
