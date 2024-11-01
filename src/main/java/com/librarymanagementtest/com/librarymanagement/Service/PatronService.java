package com.librarymanagementtest.com.librarymanagement.Service;
import com.librarymanagementtest.com.librarymanagement.Repository.PatronRepository;

import jakarta.transaction.Transactional;

import com.librarymanagementtest.com.librarymanagement.Model.Patron;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatronService {

    @Autowired
    private PatronRepository patronsRepository;

    public  Iterable<Patron> getPatrons() {
        return patronsRepository.findAll();
    }

    public Patron getPatronById(long id) {

        Optional<Patron> patronNullable = patronsRepository.findById(id);
        if ( !patronNullable.isPresent())
        {
            return new Patron();
        }
        
        return patronNullable.get();
    }

    @Transactional
    public Patron save(Patron patron) {

        return patronsRepository.save(patron);
    }

    @Transactional
    public Patron updatePatron(long id, Patron patron) {
        patron.setId(id);
        return patronsRepository.save(patron);
    }

    @Transactional
    public Patron removePatron(long id) {
        
        Optional<Patron> patronAboutToBeDeleted = patronsRepository.findById(id);
        if(!patronAboutToBeDeleted.isPresent())
        {
            return null;
        }
        patronsRepository.deleteById(id);
        return patronAboutToBeDeleted.get();
    }

}
