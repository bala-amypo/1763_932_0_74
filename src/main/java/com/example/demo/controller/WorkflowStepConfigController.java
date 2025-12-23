package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.WorkflowStepConfig;
import com.example.demo.service.WorkflowStepConfigService;

@RestController
@RequestMapping("/api/steps")
public class WorkflowStepConfigController {

    private final WorkflowStepConfigService service;

    public WorkflowStepConfigController(WorkflowStepConfigService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public WorkflowStepConfig create(@RequestBody WorkflowStepConfig step) {
        return service.createStep(step);
    }

    // READ by ID
    @GetMapping("/{id}")
    public WorkflowStepConfig getById(@PathVariable Long id) {
        return service.getStepById(id);
    }

    // READ by Template ID
    @GetMapping("/template/{templateId}")
    public List<WorkflowStepConfig> getByTemplate(@PathVariable Long templateId) {
        return service.getStepsByTemplateId(templateId);
    }

    // UPDATE
    @PutMapping("/{id}")
    public WorkflowStepConfig update(@PathVariable Long id,
                                     @RequestBody WorkflowStepConfig step) {
        return service.updateStep(id, step);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteStep(id);
        return "Workflow Step deleted successfully";
    }
}
