package com.tplogistics.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GarageResponse {
    @JsonProperty("id")
    String garageId;
    String name;
    String address;
    Double latitude;
    Double longitude;
}
