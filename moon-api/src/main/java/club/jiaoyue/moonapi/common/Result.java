package club.jiaoyue.moonapi.common;

import lombok.Data;

@Data
public class Result<T> {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 成功返回
     */
    public static <T> Result<T> success(T data) {

        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMsg("success");
        result.setData(data);

        return result;
    }

    /**
     * 失败返回
     */
    public static <T> Result<T> error(String msg) {

        Result<T> result = new Result<>();
        result.setCode(500);
        result.setMsg(msg);

        return result;
    }

}