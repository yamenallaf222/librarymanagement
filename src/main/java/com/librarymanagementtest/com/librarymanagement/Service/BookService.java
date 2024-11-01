package com.librarymanagementtest.com.librarymanagement.Service;

import com.librarymanagementtest.com.librarymanagement.Repository.BooksRepository;

import jakarta.transaction.Transactional;

import com.librarymanagementtest.com.librarymanagement.Model.Book;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BooksRepository booksRepository;

    public  Iterable<Book> getBooks() {
        return booksRepository.findAll();
    }

    public Book getBookById(long id) {

        Optional<Book> bookNullable = booksRepository.findById(id);
        if ( !bookNullable.isPresent())
        {
            return new Book();
        }
        
        return bookNullable.get();
    }

    @Transactional
    public Book save(Book book) {

        return booksRepository.save(book);
    }

    @Transactional
    public Book updateBook(long id, Book book) {
        book.setId(id);
        return booksRepository.save(book);
    }

    @Transactional
    public Book removeBook(long id) {
        
        Optional<Book> bookAboutToBeDeleted = booksRepository.findById(id);
        if(!bookAboutToBeDeleted.isPresent())
        {
            return null;
        }
        booksRepository.deleteById(id);
        return bookAboutToBeDeleted.get();
    }

}
