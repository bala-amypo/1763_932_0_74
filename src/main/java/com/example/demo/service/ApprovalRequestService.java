package com.example.demo.service;

import java.util.List;
import com.example.demo.model.ApprovalRequest;

public interface ApprovalRequestService {

    ApprovalRequest createRequest(ApprovalRequest request);

    ApprovalRequest getRequestById(Long id);

    List<ApprovalRequest> getAllRequests();

    List<ApprovalRequest> getRequestsByRequester(Long requesterId);

    ApprovalRequest updateRequest(Long id, ApprovalRequest request);

    void deleteRequest(Long id);
}
