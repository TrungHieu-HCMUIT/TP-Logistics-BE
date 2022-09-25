package com.tplogistics.core.domain.enums;

public enum LocationType {
    PICK_UP(1),
    DELIVERY(2),
    GARAGE(3),
    TRACKING(4);

    public final Integer typeCode;

    LocationType(Integer code) {
        typeCode = code;
    }

    public static LocationType fromInt(Integer value) {
        for (LocationType status: values()) {
            if (status.typeCode.equals(value)) {
                return status;
            }
        }
        return null;
    }

}
