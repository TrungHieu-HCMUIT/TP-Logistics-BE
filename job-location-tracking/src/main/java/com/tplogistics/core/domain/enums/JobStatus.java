package com.tplogistics.core.domain.enums;

public enum JobStatus {
    OPEN(1),
    ASSIGNED(2),
    DRIVER_JOB_STARTED(3),
    DRIVER_PICKUP_ARRIVED(4),
    DRIVER_PICKUP_DONE(5),
    DRIVER_DELIVERY_STARTED(6),
    DRIVER_DELIVERY_ARRIVED(7),
    DRIVER_DISCHARGED_DONE(8),
    DRIVER_JOB_COMPLETED(9),
    CUSTOMER_CANCELLED(10);

    public final Integer statusCode;

    JobStatus(Integer code) {
        statusCode = code;
    }

    public static JobStatus fromInt(Integer value) {
        for (JobStatus status: values()) {
            if (status.statusCode.equals(value)) {
                return status;
            }
        }
        return null;
    }

}
