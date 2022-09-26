package controller.base;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseResponse<T> {
    private Integer statusCode;
    private T data;
    private String message;
    private String key;

    public static <T> BaseResponse<T> success(T t) {
        return new BaseResponse<>(200, t, null, null);
    }
}
