package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ApprovalRequest;
import com.example.demo.repository.ApprovalRequestRepository;
import com.example.demo.service.ApprovalRequestService;

@Service
public class ApprovalRequestServiceImpl implements ApprovalRequestService {

    private final ApprovalRequestRepository repository;

    public ApprovalRequestServiceImpl(ApprovalRequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public ApprovalRequest createRequest(ApprovalRequest request) {

        // default values
        request.setStatus("PENDING");
        request.setCurrentLevel(1);
        request.setCreatedAt(LocalDateTime.now());

        return repository.save(request);
    }

    @Override
    public ApprovalRequest getRequestById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Approval Request not found with id: " + id));
    }

    @Override
    public List<ApprovalRequest> getAllRequests() {
        return repository.findAll();
    }

    @Override
    public List<ApprovalRequest> getRequestsByRequester(Long requesterId) {
        return repository.findByRequesterId(requesterId);
    }

    @Override
    public ApprovalRequest updateRequest(Long id, ApprovalRequest request) {

        ApprovalRequest existing = getRequestById(id);

        existing.setTemplateId(request.getTemplateId());
        existing.setRequesterId(request.getRequesterId());
        existing.setRequestTitle(request.getRequestTitle());
        existing.setRequestPayloadJson(request.getRequestPayloadJson());
        existing.setStatus(request.getStatus());
        existing.setCurrentLevel(request.getCurrentLevel());

        return repository.save(existing);
    }

    @Override
    public void deleteRequest(Long id) {
        ApprovalRequest existing = getRequestById(id);
        repository.delete(existing);
    }
}
