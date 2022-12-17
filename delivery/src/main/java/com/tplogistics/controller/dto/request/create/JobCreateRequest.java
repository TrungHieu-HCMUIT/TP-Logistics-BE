package com.tplogistics.controller.dto.request.create;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class JobCreateRequest {
    @NotNull(message = "Invalid route id")
    String routeId;
}
