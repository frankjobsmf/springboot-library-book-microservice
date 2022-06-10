package com.library.bookmicroservice.Dao;

import com.library.bookmicroservice.Entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookDAO extends CrudRepository<Book, Long> {
}
