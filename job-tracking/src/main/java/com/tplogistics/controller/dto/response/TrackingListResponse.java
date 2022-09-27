package com.tplogistics.controller.dto.response;

import com.tplogistics.core.domain.entity.JobTracking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackingListResponse {
    private UUID jobId;
    private List<TrackingResponse> trackingList;
}
