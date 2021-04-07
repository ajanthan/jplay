package com.github.ajanthan.learning.book.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Book {
    private @Id
    String Id;
    private String Author;
    private String Title;
    private String Genre;
    private Float Price;
    private Date PublishedDate;
    private String Description;

    public Book() {
    }

    public Book(String id, String author, String title, String genre, Float price, Date publishedDate, String description) {
        Id = id;
        Author = author;
        Title = title;
        Genre = genre;
        Price = price;
        PublishedDate = publishedDate;
        Description = description;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public Float getPrice() {
        return Price;
    }

    public void setPrice(Float price) {
        Price = price;
    }

    public Date getPublishedDate() {
        return PublishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        PublishedDate = publishedDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
