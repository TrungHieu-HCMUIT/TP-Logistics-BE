package com.tplogistics.controller;

import com.tplogistics.controller.dto.request.RecordTrackingRequest;
import com.tplogistics.controller.dto.response.TrackingListResponse;
import com.tplogistics.core.service.JobTrackingService;
import controller.base.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class TrackingController extends BaseController {

    private final JobTrackingService jobTrackingService;

    @PostMapping("v1/record")
    ResponseEntity<Object> recordTracking(@RequestBody RecordTrackingRequest request) {
        Boolean result = jobTrackingService.recordTracking(request);
        return successResponse(result);
    }

    @GetMapping("v1/tracking-list/{jobId}")
    ResponseEntity<Object> getTrackingList(@PathVariable UUID jobId) {
        TrackingListResponse result = jobTrackingService.getJobTrackingList(jobId);
        return successResponse(result);
    }
}
