package com.github.ajanthan.learning.book;

import com.github.ajanthan.learning.book.model.Book;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileReader;
import java.sql.Date;

@Configuration
public class BookDataLoader {
    @Value("${data.file}")
    private String dataFileLocation;

    @Bean
    CommandLineRunner initDatabase(BookRepository repository) {
        return args -> {
            FileReader data = new FileReader(dataFileLocation);
            CSVParser parser = new CSVParser(data, CSVFormat.DEFAULT.withFirstRecordAsHeader());
            Iterable<CSVRecord> records = parser.getRecords();
            for (CSVRecord record : records) {
                Book book=new Book();
                book.setId(record.get("id"));
                book.setAuthor(record.get("author"));
                book.setTitle(record.get("title"));
                book.setGenre(record.get("genre"));
                book.setPrice(Float.parseFloat(record.get("price")));
                book.setPublishedDate(Date.valueOf(record.get("publish_date").trim()));
                book.setDescription(record.get("description"));
                repository.save(book);
            }
        };
    }
}
