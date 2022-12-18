package com.tplogistics.controller;

import com.tplogistics.core.service.JobService;
import controller.base.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/job")
public class JobController extends BaseController {

    private final JobService jobService;

}
