package com.trunnghieu.tplogistics.base;

import org.springframework.http.ResponseEntity;

public class BaseController {

    public ResponseEntity<Object> successResponse(Object data) {
        BaseResponse<Object> response = BaseResponse.success(data);
        return ResponseEntity.ok(response);
    }
}
