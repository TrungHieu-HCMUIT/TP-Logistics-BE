package com.tplogistics.core.domain.enums;

public enum DriverJobType {
    PARTIAL(1),
    FULL(2);

    public final Integer typeCode;

    DriverJobType(Integer code) {
        typeCode = code;
    }

    public static DriverJobType fromInt(Integer value) {
        for (DriverJobType status: values()) {
            if (status.typeCode.equals(value)) {
                return status;
            }
        }
        return null;
    }

}
