package com.library.bookmicroservice.Controller;

import com.library.bookmicroservice.Entity.Book;
import com.library.bookmicroservice.Repository.IBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private IBook iBook;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks(){
        return iBook.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveBook(@RequestBody Book book){
        iBook.saveBook(book);
    }

    @PutMapping("/{id}?cantidad={cantidad}")
    public void updateStock(@PathVariable Long id, @RequestParam Integer cantidad){

    }

}
