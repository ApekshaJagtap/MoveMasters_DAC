package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.RequestDao;
import com.app.enums.RequestStatus;
import com.app.pojos.Request;


@RestController
@CrossOrigin(origins = "http://localhost:3000/")

public class RequestController {
    
    @Autowired
    private RequestDao requestDao;
    
    @PostMapping("/requests")
    public ResponseEntity<String> createRequest(@RequestBody Request request) {
    	System.out.print(request);
        requestDao.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Request created successfully.");
    }
    
    @GetMapping("/notvisited")
    public ResponseEntity<List<Request>> getAllNotVisitedRequests() {
        List<Request> notVisitedRequests = requestDao.findByStatus(RequestStatus.NOTVISITED);
        return new ResponseEntity<>(notVisitedRequests, HttpStatus.OK);
    }
}
