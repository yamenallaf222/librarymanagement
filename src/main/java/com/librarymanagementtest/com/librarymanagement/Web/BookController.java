package com.librarymanagementtest.com.librarymanagement.Web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.librarymanagementtest.com.librarymanagement.Model.Book;
import com.librarymanagementtest.com.librarymanagement.Service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/api/books")
    public  Iterable<Book> getAllBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/api/books/{id}")
    public Book getBookById(@PathVariable long id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/api/books")
    //retuns added book
    public Book addBook(@RequestParam("bookData") Book book)
    {
        return bookService.save(book);
    }

    @PutMapping("/api/books/{id}")
    public Book updateBook(@PathVariable long id, @RequestParam Book book)
    {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/api/books/{id}")
    public Book removeBook(@PathVariable long id)
    {
        Book removed = bookService.removeBook(id);
        //essentially id did not find any book with such id 
        if(removed.getId() == -1) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        
        return removed;
    }
    
    
    
    


}
