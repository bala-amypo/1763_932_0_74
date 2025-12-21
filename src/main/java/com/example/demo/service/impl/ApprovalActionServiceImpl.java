package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ApprovalAction;
import com.example.demo.repository.ApprovalActionRepository;
import com.example.demo.service.ApprovalActionService;

@Service
public class ApprovalActionServiceImpl implements ApprovalActionService {

    private final ApprovalActionRepository repository;

    public ApprovalActionServiceImpl(ApprovalActionRepository repository) {
        this.repository = repository;
    }

    @Override
    public ApprovalAction createAction(ApprovalAction action) {

        // set default action date
        action.setActionDate(LocalDateTime.now());

        return repository.save(action);
    }

    @Override
    public ApprovalAction getActionById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Approval Action not found with id: " + id));
    }

    @Override
    public List<ApprovalAction> getActionsByRequestId(Long requestId) {
        return repository.findByRequestId(requestId);
    }

    @Override
    public List<ApprovalAction> getAllActions() {
        return repository.findAll();
    }

    @Override
    public ApprovalAction updateAction(Long id, ApprovalAction action) {

        ApprovalAction existing = getActionById(id);

        existing.setRequestId(action.getRequestId());
        existing.setApproverId(action.getApproverId());
        existing.setLevelNumber(action.getLevelNumber());
        existing.setAction(action.getAction());
        existing.setComments(action.getComments());

        return repository.save(existing);
    }

    @Override
    public void deleteAction(Long id) {
        ApprovalAction existing = getActionById(id);
        repository.delete(existing);
    }
}
