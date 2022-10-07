package com.tplogistics.controller.dto.request.create;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class RouteCreateRequest {
    @NotNull(message = "Invalid location id")
    String fromLocationId;

    @NotNull(message = "Invalid location id")
    String toLocationId;

    @NotNull(message = "Length cannot be null")
    @Positive(message = "Invalid length")
    Double length;

    @NotNull(message = "Cost cannot be null")
    @Positive(message = "Invalid cost")
    Double tripBasedCost;

    @NotNull(message = "Limit cannot be null")
    @Positive(message = "Invalid limit")
    Double tonBasedLimit;
}
