package com.librarymanagementtest.com.librarymanagement.Service;

import com.librarymanagementtest.com.librarymanagement.Repository.BorrowingRepository;

import jakarta.transaction.Transactional;

import com.librarymanagementtest.com.librarymanagement.Model.Book;
import com.librarymanagementtest.com.librarymanagement.Model.BorrowingRecord;
import com.librarymanagementtest.com.librarymanagement.Model.Patron;

import java.util.Optional;
import java.util.List;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BorrowingRecordService {

    @Autowired
    private BorrowingRepository borrowingRepository;


    private long findBorrowingdRecordBy(long bookId, long patronId)
    {
        List<BorrowingRecord> borrowingRecords = borrowingRepository.findAll();

       
        for(BorrowingRecord borrowingRecord : borrowingRecords)
        {
            if(borrowingRecord.getBook().getId() == bookId && borrowingRecord.getPatron().getId() == patronId)
                return borrowingRecord.getId();
        }

        return -1;
    }

    @Transactional
    public BorrowingRecord borrowBook(long bookId, long patronId, LocalDateTime returnDate)
    {


        BorrowingRecord borrowingRecord = new BorrowingRecord();


        Patron patron = new Patron();
        Book book = new Book();
        patron.setId(patronId);
        book.setId(bookId);
        borrowingRecord.setPatron(patron);
        borrowingRecord.setBook(book);
        borrowingRecord.setReturnDate(returnDate);
        
        borrowingRepository.save(borrowingRecord);

        return borrowingRecord;
    }

    @Transactional
    public BorrowingRecord returnBook(long bookId, long patronId)
    {
        Optional<BorrowingRecord> found = borrowingRepository.findById(findBorrowingdRecordBy(bookId, patronId));
        if(!found.isPresent())
        {
            return null;
        }

        borrowingRepository.delete(found.get());

        return found.get();
        
    }


}
