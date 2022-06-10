package com.library.bookmicroservice.Service;

import com.library.bookmicroservice.Dao.BookDAO;
import com.library.bookmicroservice.Entity.Author;
import com.library.bookmicroservice.Entity.Book;
import com.library.bookmicroservice.Entity.Category;
import com.library.bookmicroservice.Repository.IBook;
import com.library.bookmicroservice.RestClients.AuthorFeign;
import com.library.bookmicroservice.RestClients.CategoryFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService implements IBook {

    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private AuthorFeign authorFeign;

    @Autowired
    private CategoryFeign categoryFeign;


    @Override
    public List<Book> getAll() {

        List<Book> books = (List<Book>) bookDAO.findAll();

        return books.stream().map(book -> {
            Author au = authorFeign.getAuthorById(book.getAuthorId());
            Category ca = categoryFeign.getCategoryById(book.getCategoryId());
            book.setAuthor(au);
            book.setCategory(ca);
            return book;
        }).collect(Collectors.toList());
    }

    @Override
    public Book getBookById(Long id) {
        return null;
    }

    @Override
    public void saveBook(Book book) {
        bookDAO.save(book);
    }
}
