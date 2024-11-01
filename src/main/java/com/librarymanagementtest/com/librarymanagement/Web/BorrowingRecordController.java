package com.librarymanagementtest.com.librarymanagement.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.librarymanagementtest.com.librarymanagement.Model.BorrowingRecord;
import com.librarymanagementtest.com.librarymanagement.Service.BorrowingRecordService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class BorrowingRecordController {

    @Autowired
    private BorrowingRecordService borrowingRecordService;

    @PostMapping("/api/borrow/{bookId}/patron/{patronId}")
    public BorrowingRecord borrowBook(@PathVariable long bookId, @PathVariable long patronId, @RequestBody LocalDateTime returnDate) {
    
        return borrowingRecordService.borrowBook(bookId, patronId, returnDate);
    }

    @PutMapping("/api/return/{bookId}/patron/{patronId}")
    public BorrowingRecord returnBook(@PathVariable long bookId, @PathVariable long patronId) {
        
        return borrowingRecordService.returnBook(bookId, patronId);

    }
    
    


}

