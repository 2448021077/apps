package cn.jit.aquaponics.mvp.model.entity.db;

import java.util.List;

/**
 * @author zxl crazyZhangxl on 2018/9/25.
 * Describe: 登陆请求的 body
 */
public class LoginBean {
    /**
     * password : string
     * username : string
     */

    private String password;
    private String username;
    private String role;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    /**
     * snpid : string
     * times : [0]
     * values : [0]
     */

    private int snpid;
    private List<String> times;
    private List<Double> values;



    public List<String> getTimes() {
        return times;
    }

    public void setTimes(List<String> times) {
        this.times = times;
    }

    public List<Double> getValues() {
        return values;
    }

    public void setValues(List<Double> values) {
        this.values = values;
    }

    public int getSnpid() {
        return snpid;
    }

    public void setSnpid(int snpid) {
        this.snpid = snpid;
    }

}

