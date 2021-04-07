package com.github.ajanthan.learning.book.model;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String id) {
        super("Book " + id + " is not found");
    }
}
