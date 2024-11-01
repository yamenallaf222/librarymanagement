package com.librarymanagementtest.com.librarymanagement.Model;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "borrowingRecord")
public class BorrowingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public BorrowingRecord()
    {   
    }

    @ManyToOne
    @JoinColumn(name = "bookId", nullable = false)
    private Book book;
    
    @ManyToOne
    @JoinColumn(name = "patronId", nullable = false)
    private Patron patron;

    @Column(nullable = false)
    private LocalDateTime borrowingDate, returnDate;

    public LocalDateTime getBorrowingDate() {
       return borrowingDate;
    }
    public void setBorrowingDate(LocalDateTime borrowingDate) {
        this.borrowingDate = borrowingDate;
    }
    public LocalDateTime getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public Patron getPatron() {
        return patron;
    }
    public void setPatron(Patron patron) {
        this.patron = patron;
    }




}
