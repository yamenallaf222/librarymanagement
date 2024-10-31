package com.librarymanagementtest.com.librarymanagement.Web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.librarymanagementtest.com.librarymanagement.Model.Patron;
import com.librarymanagementtest.com.librarymanagement.Service.PatronService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class PatronController {
    
    @Autowired
    private PatronService patronService;

    @GetMapping("/api/patrons")
    public  Iterable<Patron> getAllPatrons() {
        return patronService.getPatrons();
    }

    @GetMapping("/api/patrons/{id}")
    public Patron getPatronById(@PathVariable long id) {
        return patronService.getPatronById(id);
    }

    @PostMapping("/api/patrons")
    //retuns added patron 
    public Patron addPatron(@RequestParam("patronData") Patron book)
    {
        return patronService.save(book);
    }

    @PutMapping("/api/patrons/{id}")
    public Patron updatePatron(@PathVariable long id, @RequestParam Patron book)
    {
        return patronService.updatePatron(id, book);
    }

    @DeleteMapping("/api/patrons/{id}")
    public Patron removePatron(@PathVariable long id)
    {
        Patron removed = patronService.removePatron(id);
        //essentially id did not find any book with such id 
        if(removed.getId() == -1) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        
        return removed;
    }
}
