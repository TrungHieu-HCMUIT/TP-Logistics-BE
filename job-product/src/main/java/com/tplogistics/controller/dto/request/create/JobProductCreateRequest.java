package com.tplogistics.controller.dto.request.create;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class JobProductCreateRequest {
    @NotBlank(message = "Invalid job id")
    String jobId;

    @NotBlank(message = "Invalid product id")
    String productId;

    @NotNull(message = "Weight cannot be null")
    @Positive(message = "Invalid weight")
    Double weight;
}
