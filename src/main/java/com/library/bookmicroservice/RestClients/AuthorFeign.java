package com.library.bookmicroservice.RestClients;


import com.library.bookmicroservice.Entity.Author;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "author-microservice", url = "http://localhost:9001/api/authors")
public interface AuthorFeign {

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id);

}
