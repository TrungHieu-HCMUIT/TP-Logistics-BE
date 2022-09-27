package com.tplogistics.core.service.impl;

import com.tplogistics.controller.dto.request.RecordTrackingRequest;
import com.tplogistics.controller.dto.response.TrackingListResponse;
import com.tplogistics.controller.dto.response.TrackingResponse;
import com.tplogistics.core.domain.entity.JobTracking;
import com.tplogistics.core.error_handling.custom_error.InvalidRequest;
import com.tplogistics.core.error_handling.custom_error.JobNotFound;
import com.tplogistics.core.service.JobTrackingService;
import com.tplogistics.repository.JobTrackingRepository;
import helper.DateTimeHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Parameter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
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
    public List<JobTracking> getJobTrackingList(UUID jobId) {
        if (jobId == null) {
            throw new InvalidRequest("ID cannot be null");
        }

        Optional<JobTracking> jobTracking = jobTrackingRepository.findById(jobId);
        if (jobTracking.isPresent()) {
            throw new JobNotFound("Job not found");
        }

        return jobTrackingRepository.findAllByJobIdOrderByCreatedAt(jobId);
    }
}
