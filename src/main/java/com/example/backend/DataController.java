package com.example.backend;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DataController {
    @Autowired
    private DataService dataService;

    @PostMapping("/data")
    public ResponseEntity<Void> storeData(@RequestBody Map<String, String> data) {
        String skey = data.get("skey"); // Changed variable name to "skey"
        String value = data.get("value");

        try {
            dataService.storeData(skey, value);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/data/{skey}")
    public ResponseEntity<Data> retrieveData(@PathVariable String skey) { // Changed parameter name to "skey"
        try {
            Data data = dataService.retrieveData(skey);
            return ResponseEntity.ok(data);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/data/{skey}")
    public ResponseEntity<Void> updateData(@PathVariable String skey, @RequestBody Map<String, String> newData) { // Changed parameter name to "skey"
        String value = newData.get("value");

        try {
            dataService.updateData(skey, value);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/data/{skey}")
    public ResponseEntity<Void> deleteData(@PathVariable String skey) { // Changed parameter name to "skey"
        try {
            dataService.deleteData(skey);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
