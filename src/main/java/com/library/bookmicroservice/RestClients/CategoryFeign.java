package com.library.bookmicroservice.RestClients;


import com.library.bookmicroservice.Entity.Category;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "category-microservice", url = "http://localhost:9002/api/categories")
public interface CategoryFeign {

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id);

}
