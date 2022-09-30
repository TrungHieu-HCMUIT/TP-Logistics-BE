package com.tplogistics.controller;

import com.tplogistics.controller.dto.request.RecordTrackingRequest;
import com.tplogistics.controller.dto.response.TrackingListResponse;
import com.tplogistics.controller.dto.response.TrackingResponse;
import com.tplogistics.core.domain.entity.JobTracking;
import com.tplogistics.core.service.JobTrackingService;
import controller.base.BaseController;
import helper.DateTimeHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class TrackingController extends BaseController {

    private final JobTrackingService jobTrackingService;

    @PostMapping("v1/record")
    ResponseEntity<Object> recordTracking(@Valid @RequestBody RecordTrackingRequest request) {
        Boolean result = jobTrackingService.recordTracking(request);
        return successResponse(result);
    }

    @GetMapping("v1/tracking-list/{jobId}")
    ResponseEntity<Object> getTrackingList(@PathVariable UUID jobId) {
        List<JobTracking> jobTrackingList = jobTrackingService.getJobTrackingList(jobId);

        List<TrackingResponse> trackingResponseList = jobTrackingList.stream().map(e -> {
            return TrackingResponse.builder()
                    .latitude(e.getLatitude())
                    .longitude(e.getLongitude())
                    .createdAt(DateTimeHelper.toEpochSecond(e.getCreatedAt()))
                    .build();
        }).toList();

        TrackingListResponse response = new TrackingListResponse(jobId, trackingResponseList);
        return successResponse(response);
    }
}
