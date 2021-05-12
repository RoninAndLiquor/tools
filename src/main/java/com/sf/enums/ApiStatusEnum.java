package com.sf.enums;

/**
 * 定义返回状态
 */
public enum ApiStatusEnum {

    SUCCESS("0", "成功"),
    FAIL("-1", "失败"),
    PARAMETER_BAD("400", "参数有误"),
    LOGIN_INVALID("401","登陆已失效"),
    ERROR("500", "系统繁忙，请稍后重试"),

    ;
    private final String code;
    private final String value;

    ApiStatusEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
