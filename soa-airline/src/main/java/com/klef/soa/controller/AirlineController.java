package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.soa.entity.Airline;
import com.klef.soa.service.AirlineService;

@RestController
@RequestMapping("/airline")

public class AirlineController
{

    @Autowired
    private AirlineService service;

    @GetMapping("/")
    public String home()
    {
        return "airline project";
    }

    // Insert
    @PostMapping("/add")
    public ResponseEntity<String> addAirline(@RequestBody Airline airline)
    {
        String output = service.addAirline(airline);
        return ResponseEntity.status(201).body(output);
    }

    // Update
    @PutMapping("/update")
    public ResponseEntity<String> updateAirline(@RequestBody Airline airline)
    {
        String output = service.updateAirline(airline);
        return ResponseEntity.ok(output);
    }

    // Delete
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAirline(@RequestParam long id)
    {
        String output = service.deleteAirline(id);
        return ResponseEntity.ok(output);
    }

    // Display All
    @GetMapping("/displayall")
    public ResponseEntity<List<Airline>> displayAllAirlines()
    {
        return ResponseEntity.ok(service.displayAllAirlines());
    }

    // Display By ID
    @GetMapping("/display/{id}")
    public ResponseEntity<?> displayById(@PathVariable long id)
    {
        Airline airline = service.displayById(id);

        if (airline != null)
        {
            return ResponseEntity.ok(airline);
        }

        return ResponseEntity.ok("Airline ID Not Found");
    }

    // Derived Query 1
    @GetMapping("/displaybyname/{name}")
    public ResponseEntity<List<Airline>> displayByName(@PathVariable String name)
    {
        return ResponseEntity.ok(service.displayByName(name));
    }

    // Derived Query 2
    @GetMapping("/displaybytype/{type}")
    public ResponseEntity<List<Airline>> displayByType(@PathVariable String type)
    {
        return ResponseEntity.ok(service.displayByType(type));
    }

    // Count
    @GetMapping("/count")
    public ResponseEntity<String> displayAirlineCount()
    {
        long count = service.displayAirlineCount();
        return ResponseEntity.ok("Total Airlines = " + count);
    }
}
