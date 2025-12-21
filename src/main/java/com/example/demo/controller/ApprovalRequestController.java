package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.ApprovalRequest;
import com.example.demo.service.ApprovalRequestService;

@RestController
@RequestMapping("/api/requests")
public class ApprovalRequestController {

    private final ApprovalRequestService service;

    public ApprovalRequestController(ApprovalRequestService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ApprovalRequest create(@RequestBody ApprovalRequest request) {
        return service.createRequest(request);
    }

    // READ by ID
    @GetMapping("/{id}")
    public ApprovalRequest getById(@PathVariable Long id) {
        return service.getRequestById(id);
    }

    // READ all
    @GetMapping
    public List<ApprovalRequest> getAll() {
        return service.getAllRequests();
    }

    // READ by requester
    @GetMapping("/requester/{requesterId}")
    public List<ApprovalRequest> getByRequester(@PathVariable Long requesterId) {
        return service.getRequestsByRequester(requesterId);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ApprovalRequest update(@PathVariable Long id,
                                  @RequestBody ApprovalRequest request) {
        return service.updateRequest(id, request);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteRequest(id);
        return "Approval Request deleted successfully";
    }
}
