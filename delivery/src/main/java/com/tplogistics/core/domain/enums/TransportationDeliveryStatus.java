package com.tplogistics.core.domain.enums;

public enum TransportationDeliveryStatus {
    AT_GARAGE(1),
    ON_ROAD(2);

    public final Integer statusCode;

    TransportationDeliveryStatus(Integer code) {
        statusCode = code;
    }

    public static TransportationDeliveryStatus fromInt(Integer value) {
        for (TransportationDeliveryStatus status: values()) {
            if (status.statusCode.equals(value)) {
                return status;
            }
        }
        return null;
    }

}
