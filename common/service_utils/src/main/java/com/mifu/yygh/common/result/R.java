package com.mifu.yygh.common.result;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@ToString
public class R {

    private Integer code;
    private Boolean success;
    private String message;
    private Map<String, Object> data = new HashMap<String, Object>();

    private R() { // 1.为了方便链式编程 让外界能以R.ok().code().xxx的形式调用
        // 2.构造器私有化，不让外界创建R对象
    }

    public static R ok() {
        R r = new R(); // 3.内部创建R对象
        r.code = REnum.SUCCESS.getCode();
        r.success = REnum.SUCCESS.getFlag();
        r.message = REnum.SUCCESS.getMessage();
        return r; // 4.返回R对象  这样就会在调用 R.ok()时得到的还是R对象,就能继续调用 .code等方法
    }

    public static R error() {
        R r = new R();
        r.code = REnum.ERROR.getCode(); //原先是r.code = 20001,属于硬编码方式,不太规范   可以采用枚举类,让代码更加规范
        r.success = REnum.ERROR.getFlag();
        r.message = REnum.ERROR.getMessage();
        return r;
    }

    public R code(Integer code) {
        this.code = code;
        return this;
    }

    public R success(Boolean success) {
        this.success = success;
        return this;
    }

    public R message(String message) {
        this.message = message;
        return this;
    }

    public R data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public R data(Map<String, Object> map) {
        this.data = map;
        return this;
    }


}
