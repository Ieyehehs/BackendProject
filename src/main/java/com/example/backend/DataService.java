package com.example.backend;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class DataService {
    @Autowired
    private DataRepository dataRepository;

    public void storeData(String skey, String value) {
        // Validate input fields
        if (skey == null || skey.isEmpty()) {
            throw new IllegalArgumentException("Invalid key. Please provide a valid key.");
        }
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Invalid value. Please provide a valid value.");
        }

        // Check if key already exists
        Data existingData = dataRepository.findBySkey(skey);
        if (existingData != null) {
            throw new IllegalArgumentException("The provided key already exists in the database. To update an existing key, use the update API.");
        }

        // Save the data
        Data data = new Data();
        data.setSkey(skey);
        data.setValue(value);
        dataRepository.save(data);
    }

    public Data retrieveData(String skey) {
        // Validate input fields
        if (skey == null || skey.isEmpty()) {
            throw new IllegalArgumentException("Invalid key. Please provide a valid key.");
        }

        // Retrieve data by key
        Data data = dataRepository.findBySkey(skey);
        if (data == null) {
            throw new IllegalArgumentException("The provided key does not exist in the database.");
        }

        return data;
    }

    public void updateData(String skey, String newValue) {
        // Validate input fields
        if (skey == null || skey.isEmpty()) {
            throw new IllegalArgumentException("Invalid key. Please provide a valid key.");
        }
        if (newValue == null || newValue.isEmpty()) {
            throw new IllegalArgumentException("Invalid value. Please provide a valid value.");
        }

        // Retrieve data by key
        Data data = dataRepository.findBySkey(skey);
        if (data == null) {
            throw new IllegalArgumentException("The provided key does not exist in the database.");
        }

        // Update the value
        data.setValue(newValue);
        dataRepository.save(data);
    }

    public void deleteData(String skey) {
        // Validate input fields
        if (skey == null || skey.isEmpty()) {
            throw new IllegalArgumentException("Invalid key. Please provide a valid key.");
        }

        // Retrieve data by key
        Data data = dataRepository.findBySkey(skey);
        if (data == null) {
            throw new IllegalArgumentException("The provided key does not exist in the database.");
        }

        // Delete the data
        dataRepository.delete(data);
    }
}
