package com.tplogistics.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import consts.Const;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrackingResponse {
    private Double latitude;
    private Double longitude;
    @JsonFormat(pattern = Const.DEFAULT_DATE_TIME_FORMAT)
    private LocalDateTime createdAt;
}
