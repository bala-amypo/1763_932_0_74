package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.service.WorkflowTemplateService;

@RestController
@RequestMapping("/api/templates")
public class WorkflowTemplateController {

    private final WorkflowTemplateService service;

    public WorkflowTemplateController(WorkflowTemplateService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public WorkflowTemplate create(@RequestBody WorkflowTemplate template) {
        return service.createTemplate(template);
    }

    // READ by ID
    @GetMapping("/{id}")
    public WorkflowTemplate getById(@PathVariable Long id) {
        return service.getTemplateById(id);
    }

    // READ all
    @GetMapping
    public List<WorkflowTemplate> getAll() {
        return service.getAllTemplates();
    }

    // UPDATE
    @PutMapping("/{id}")
    public WorkflowTemplate update(@PathVariable Long id,
                                   @RequestBody WorkflowTemplate template) {
        return service.updateTemplate(id, template);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteTemplate(id);
        return "Workflow Template deleted successfully";
    }
}
