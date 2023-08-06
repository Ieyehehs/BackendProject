package com.example.backend;

import org.springframework.data.repository.CrudRepository;

public interface DataRepository extends CrudRepository<Data, Long> {
    Data findBySkey(String skey); // Add this method to retrieve data by skey
}
