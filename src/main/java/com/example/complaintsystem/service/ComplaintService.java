package com.example.complaintsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.complaintsystem.entity.Complaint;
import com.example.complaintsystem.repository.ComplaintRepository;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository repository;

    // create complaint
    public Complaint createComplaint(Complaint complaint) {
        complaint.setStatus("Pending");
        return repository.save(complaint);
    }

    // get all complaints
    public List<Complaint> getAllComplaints() {
        return repository.findAll();
    }

    // get complaint by id
    public Complaint getComplaintById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // delete complaint
    public void deleteComplaint(Long id) {
        repository.deleteById(id);
    }
    public Complaint updateStatus(Long id, String status) {
    Complaint complaint = repository.findById(id).orElse(null);

    if (complaint != null) {
        complaint.setStatus(status);
        return repository.save(complaint);
    }

    return null;
}
}