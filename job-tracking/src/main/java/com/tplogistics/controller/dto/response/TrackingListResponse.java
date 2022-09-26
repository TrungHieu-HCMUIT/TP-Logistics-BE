package com.tplogistics.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class TrackingListResponse {
    private UUID jobId;
    private List<TrackingResponse> trackingList;
}
