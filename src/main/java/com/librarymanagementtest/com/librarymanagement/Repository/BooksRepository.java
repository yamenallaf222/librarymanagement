package com.librarymanagementtest.com.librarymanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.librarymanagementtest.com.librarymanagement.Model.Book;

public interface BooksRepository extends JpaRepository<Book, Long>{

}