package com.tplogistics.core.service.impl;

import com.tplogistics.controller.dto.request.RecordTrackingRequest;
import com.tplogistics.controller.dto.response.TrackingListResponse;
import com.tplogistics.controller.dto.response.TrackingResponse;
import com.tplogistics.core.domain.entity.JobTracking;
import com.tplogistics.core.service.JobTrackingService;
import com.tplogistics.repository.JobTrackingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobTrackingServiceImpl implements JobTrackingService {

    private final JobTrackingRepository jobTrackingRepository;

    @Override
    public boolean recordTracking(RecordTrackingRequest request) {
        JobTracking jobTracking = JobTracking.builder()
                .jobId(request.getJobId())
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .createdAt(LocalDateTime.now())
                .build();

        var result = jobTrackingRepository.save(jobTracking);
        return result.getId() != null;
    }

    @Override
    public TrackingListResponse getJobTrackingList(UUID jobId) {
        //TODO: Add exception handle here
//        if (jobId == null) {
//            throw new
//        }
        List<JobTracking> jobTrackingList = jobTrackingRepository.getAllByJobIdOrderByCreatedAt(jobId);
        List<TrackingResponse> trackingResponseList = jobTrackingList.stream().map(e -> {
            return TrackingResponse.builder()
                    .latitude(e.getLatitude())
                    .longitude(e.getLongitude())
                    .createdAt(e.getCreatedAt())
                    .build();
        }).toList();

        return new TrackingListResponse(jobId, trackingResponseList);
    }
}
