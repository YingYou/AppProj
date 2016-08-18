package yw.com.servicecore.model;

import java.io.Serializable;

/**
 * Created by yangwei on 16/8/17.
 */
public class BaseEntity implements Serializable{


    private String code;
    private String msg;
    private int time;
    private double _ut;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double get_ut() {
        return _ut;
    }

    public void set_ut(double _ut) {
        this._ut = _ut;
    }

}
