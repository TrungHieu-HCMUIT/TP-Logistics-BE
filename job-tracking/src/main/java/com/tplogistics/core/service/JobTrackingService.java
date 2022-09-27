package com.tplogistics.core.service;

import com.tplogistics.controller.dto.request.RecordTrackingRequest;
import com.tplogistics.core.domain.entity.JobTracking;

import java.util.List;
import java.util.UUID;

public interface JobTrackingService {
    boolean recordTracking(RecordTrackingRequest request);
    List<JobTracking> getJobTrackingList(UUID jobId);
}
