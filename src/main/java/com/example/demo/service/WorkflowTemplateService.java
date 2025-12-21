package com.example.demo.service;

import java.util.List;
import com.example.demo.model.WorkflowTemplate;

public interface WorkflowTemplateService {

    WorkflowTemplate createTemplate(WorkflowTemplate template);

    WorkflowTemplate getTemplateById(Long id);

    List<WorkflowTemplate> getAllTemplates();

    WorkflowTemplate updateTemplate(Long id, WorkflowTemplate template);

    void deleteTemplate(Long id);
}
