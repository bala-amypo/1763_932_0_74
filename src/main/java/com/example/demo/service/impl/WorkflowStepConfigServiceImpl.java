package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.WorkflowStepConfig;
import com.example.demo.repository.WorkflowStepConfigRepository;
import com.example.demo.service.WorkflowStepConfigService;

@Service
public class WorkflowStepConfigServiceImpl implements WorkflowStepConfigService {

    private final WorkflowStepConfigRepository repository;

    public WorkflowStepConfigServiceImpl(WorkflowStepConfigRepository repository) {
        this.repository = repository;
    }

    @Override
    public WorkflowStepConfig createStep(WorkflowStepConfig step) {
        return repository.save(step);
    }

    @Override
    public WorkflowStepConfig getStepById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Workflow Step not found with id: " + id));
    }

    @Override
    public List<WorkflowStepConfig> getStepsByTemplateId(Long templateId) {
        return repository.findByTemplateId(templateId);
    }

    @Override
    public WorkflowStepConfig updateStep(Long id, WorkflowStepConfig step) {

        WorkflowStepConfig existing = getStepById(id);

        existing.setTemplateId(step.getTemplateId());
        existing.setLevelNumber(step.getLevelNumber());
        existing.setApproverRole(step.getApproverRole());
        existing.setIsFinalStep(step.getIsFinalStep());
        existing.setInstructions(step.getInstructions());

        return repository.save(existing);
    }

    @Override
    public void deleteStep(Long id) {
        WorkflowStepConfig existing = getStepById(id);
        repository.delete(existing);
    }
}
