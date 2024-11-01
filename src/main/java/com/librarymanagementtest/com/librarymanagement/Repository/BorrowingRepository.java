package com.librarymanagementtest.com.librarymanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.librarymanagementtest.com.librarymanagement.Model.BorrowingRecord;

public interface BorrowingRepository extends JpaRepository<BorrowingRecord, Long>{

}
