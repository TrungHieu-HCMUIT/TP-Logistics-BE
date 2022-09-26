package com.tplogistics.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class RecordTrackingRequest {
    private UUID jobId;
    private Double latitude;
    private Double longitude;
}
