package com.tplogistics.core.service.impl;

import com.tplogistics.core.service.JobService;
import com.tplogistics.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobTrackingServiceImpl implements JobService {

    private final JobRepository jobRepository;

}
