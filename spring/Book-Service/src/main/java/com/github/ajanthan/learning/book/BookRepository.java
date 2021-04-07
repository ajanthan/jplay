package com.github.ajanthan.learning.book;

import com.github.ajanthan.learning.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
