package com.clockin.clockin_backend.model;

import org.springframework.data.repository.CrudRepository;

public interface ProductRespository extends CrudRepository<Product, String> {

    @Override
    void delete(Product deleted);

}
