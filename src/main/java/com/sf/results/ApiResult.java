package com.sf.results;

import com.sf.enums.ApiStatusEnum;

import java.io.Serializable;

public class ApiResult<T> implements Serializable {

    private String code;
    private String msg;
    private T data;

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    private ApiResult() {
    }

    private ApiResult(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private ApiResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * <li> 是否是成功状态</li>
     * @return boolean
     */
    public boolean isSuccess() {
        return ApiStatusEnum.SUCCESS.getCode().equals(this.code);
    }

    /**
     * <li> 是否是错误状态</li>
     * @return boolean
     */
    public boolean isError(){
        return ApiStatusEnum.ERROR.getCode().equals(this.code);
    }

    /**
     * <li> 是否是失败状态</li>
     * @return boolean
     */
    public boolean isFail(){
        return ApiStatusEnum.FAIL.getCode().equals(this.code);
    }

    /**
     * <li> 判断是否处于某个状态</li>
     * @param code 编码
     * @return
     */
    public boolean isStatus(String code){
        if(code == this.code){
            return true;
        }
        if(code == null || this.code == null){
            return false;
        }
        return code.equals(this.code);
    }

    /**
     * <li> 创建成功返回 不包含数据</li>
     * @param <T>
     * @return ApiResult<T>
     */
    public static <T> ApiResult<T> createBySuccess() {
        return new ApiResult<T>(ApiStatusEnum.SUCCESS.getCode(), ApiStatusEnum.SUCCESS.getValue());
    }

    /**
     * <li> 创建成功返回 自定义消息 不包含数据</li>
     * @param msg 消息提示
     * @return ApiResult<T>
     */
    public static <T> ApiResult<T> createBySuccessMsg(String msg) {
        return new ApiResult<T>(ApiStatusEnum.SUCCESS.getCode(), msg);
    }

    /**
     * <li> 创建成功返回 传入数据</li>
     * @param data 数据
     * @param <T>
     * @return ApiResult<T>
     */
    public static <T> ApiResult<T> createBySuccess(T data) {
        return new ApiResult<T>(ApiStatusEnum.SUCCESS.getCode(), ApiStatusEnum.SUCCESS.getValue(), data);
    }

    /**
     * <li> 创建成功返回 自定义消息 包含返回数据</li>
     * @param msg 消息提示
     * @param data 返回数据
     * @param <T>
     * @return ApiResult<T>
     */
    public static <T> ApiResult<T> createBySuccess(String msg, T data) {
        return new ApiResult<T>(ApiStatusEnum.SUCCESS.getCode(), msg, data);
    }

    /**
     * <li> 创建错误返回 不包含数据</li>
     * @param <T>
     * @return ApiResult<T>
     */
    public static <T> ApiResult<T> createByError() {
        return new ApiResult<T>(ApiStatusEnum.ERROR.getCode(), ApiStatusEnum.ERROR.getValue());
    }

    /**
     * <li> 创建错误返回  自定义消息</li>
     * @param <T>
     * @return ApiResult<T>
     */
    public static <T> ApiResult<T> createByError(String msg) {
        return new ApiResult<T>(ApiStatusEnum.ERROR.getCode(), msg);
    }

    /**
     * <li> 创建自定义 枚举 code msg返回</li>
     * @param apiStatusEnum 消息枚举
     * @param <T>
     * @return  ApiResult<T>
     */
    public static <T> ApiResult<T> createByCodeAndMsg(ApiStatusEnum apiStatusEnum) {
        return new ApiResult<T>(apiStatusEnum.getCode(), apiStatusEnum.getValue());
    }

    /**
     * <li> 创建自定义code msg 返回</li>
     * @param code 编码
     * @param msg 消息提示
     * @param <T>
     * @return ApiResult<T>
     */
    public static <T> ApiResult<T> createByCodeAndMsg(String code,String msg) {
        return new ApiResult<T>(code, msg);
    }

    /**
     * <li> 创建自定义 枚举 code msg消息返回 包含数据</li>
     * @param apiStatusEnum 消息枚举
     * @param data 数据
     * @param <T>
     * @return ApiResult<T>
     */
    public static  <T> ApiResult<T>  createByApiStatusAndData(ApiStatusEnum apiStatusEnum,T data){
        return new ApiResult(apiStatusEnum.getCode(), apiStatusEnum.getValue(),data);
    }

    /**
     * <li>创建自定义code msg消息返回 包含数据</li>
     * @param code 编码
     * @param msg 消息
     * @param data 数据
     * @param <T>
     * @return ApiResult<T>
     */
    public static <T> ApiResult<T> createByCodeAndMsg(String code,String msg,T data) {
        return new ApiResult<T>(code, msg,data);
    }

    /**
     * <li> 创建失败自定义消息返回</li>
     * @param failMsg 失败消息
     * @param <T>
     * @return  ApiResult<T>
     */
    public static <T> ApiResult<T> createByFailMsg(String failMsg) {
        return new ApiResult<T>(ApiStatusEnum.FAIL.getCode(), failMsg);
    }

    /**
     * <li>创建失败返回</li>
     * @param <T>
     * @return
     */
    public static <T> ApiResult<T> createByFail() {
        return new ApiResult<>(ApiStatusEnum.FAIL.getCode(), ApiStatusEnum.FAIL.getValue());
    }

}

