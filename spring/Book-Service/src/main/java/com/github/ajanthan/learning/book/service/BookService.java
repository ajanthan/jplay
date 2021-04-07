package com.github.ajanthan.learning.book.service;

import com.github.ajanthan.learning.book.BookRepository;
import com.github.ajanthan.learning.book.model.Book;
import com.github.ajanthan.learning.book.model.NotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository repository) {
        bookRepository = repository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Book[] getAllBooks() {
        return bookRepository.findAll().toArray(new Book[0]);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable("id") String id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) return book;
        else throw new NotFoundException(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateBookById(@PathVariable("id") String id, Book book) {
        if (bookRepository.existsById(id)) bookRepository.save(book);
        else throw new NotFoundException(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBookById(@PathVariable("id") String id) {
        if (bookRepository.existsById(id)) bookRepository.deleteById(id);
        else throw new NotFoundException(id);
    }

}
