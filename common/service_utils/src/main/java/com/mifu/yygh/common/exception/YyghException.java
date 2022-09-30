package com.mifu.yygh.common.exception;

// 自定义异常,可以在全局异常处理器中配置
// 就可以在发生异常时,捕获我们自己定义的这个异常
// 自定义异常想要使用,必须我们自己手动抛出，不会像其他程序异常一样由程序自动抛出
public class YyghException extends RuntimeException {
    private Integer code;
    private String message;


    public YyghException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
