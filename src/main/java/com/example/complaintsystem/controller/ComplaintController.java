package com.example.complaintsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.complaintsystem.entity.Complaint;
import com.example.complaintsystem.service.ComplaintService;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintService service;

    // create complaint
    @PostMapping
    public Complaint createComplaint(@RequestBody Complaint complaint) {
        return service.createComplaint(complaint);
    }

    // get all complaints
    @GetMapping
    public List<Complaint> getAllComplaints() {
        return service.getAllComplaints();
    }

    // get complaint by id
    @GetMapping("/{id}")
    public Complaint getComplaintById(@PathVariable Long id) {
        return service.getComplaintById(id);
    }

    // delete complaint
    @DeleteMapping("/{id}")
    public String deleteComplaint(@PathVariable Long id) {
        service.deleteComplaint(id);
        return "Complaint deleted successfully";
    }

    // update complaint status
    @PutMapping("/{id}/status")
    public Complaint updateStatus(@PathVariable Long id, @RequestParam String status) {
        return service.updateStatus(id, status);
}

}