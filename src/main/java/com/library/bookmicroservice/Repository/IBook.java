package com.library.bookmicroservice.Repository;

import com.library.bookmicroservice.Entity.Book;

import java.util.List;

public interface IBook {

    public List<Book> getAll();
    public Book getBookById(Long id);
    public void saveBook(Book book);

}
