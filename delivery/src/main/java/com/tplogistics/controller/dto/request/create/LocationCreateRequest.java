package com.tplogistics.controller.dto.request.create;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class LocationCreateRequest {
    @NotBlank(message = "Invalid name")
    String name;

    @NotBlank(message = "Invalid address")
    String address;

    @NotNull(message = "Invalid latitude")
    Double latitude;

    @NotNull(message = "Invalid longitude")
    Double longitude;
}
