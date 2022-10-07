package com.tplogistics.controller.dto.request.create;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
public class ProductCreateRequest {
    @NotNull(message = "Invalid name")
    String name;

    @NotNull(message = "Invalid unit")
    String unit;

    @NotNull(message = "Type cannot be null")
    @Positive(message = "Invalid type")
    Integer type;

    @NotNull(message = "Base price cannot be null")
    @Positive(message = "Invalid price")
    Double basePrice;
}
