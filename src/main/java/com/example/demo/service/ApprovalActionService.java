package com.example.demo.service;

import java.util.List;
import com.example.demo.model.ApprovalAction;

public interface ApprovalActionService {

    ApprovalAction createAction(ApprovalAction action);

    ApprovalAction getActionById(Long id);

    List<ApprovalAction> getActionsByRequestId(Long requestId);

    List<ApprovalAction> getAllActions();

    ApprovalAction updateAction(Long id, ApprovalAction action);

    void deleteAction(Long id);
}
