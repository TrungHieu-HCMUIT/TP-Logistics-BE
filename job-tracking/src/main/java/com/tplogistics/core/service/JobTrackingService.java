package com.tplogistics.core.service;

import com.tplogistics.controller.dto.request.RecordTrackingRequest;
import com.tplogistics.controller.dto.response.TrackingListResponse;

import java.util.UUID;

public interface JobTrackingService {
    boolean recordTracking(RecordTrackingRequest request);
    TrackingListResponse getJobTrackingList(UUID jobId);
}
