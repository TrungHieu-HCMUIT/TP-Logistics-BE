package com.tplogistics.controller.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class GarageCreateRequest {
    @NotBlank(message = "Invalid name")
    String name;

    @NotBlank(message = "Invalid address")
    String address;

    @NotNull(message = "Invalid latitude")
    Double latitude;

    @NotNull(message = "Invalid longitude")
    Double longitude;
}
