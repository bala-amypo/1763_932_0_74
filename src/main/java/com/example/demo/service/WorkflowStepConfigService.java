package com.example.demo.service;

import java.util.List;
import com.example.demo.model.WorkflowStepConfig;

public interface WorkflowStepConfigService {

    WorkflowStepConfig createStep(WorkflowStepConfig step);

    WorkflowStepConfig getStepById(Long id);

    List<WorkflowStepConfig> getStepsByTemplateId(Long templateId);

    WorkflowStepConfig updateStep(Long id, WorkflowStepConfig step);

    void deleteStep(Long id);
}
