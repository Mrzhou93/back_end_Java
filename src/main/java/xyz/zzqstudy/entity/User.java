package xyz.zzqstudy.entity;

import org.springframework.stereotype.Component;

//@Component
public class User {
    private String openId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Override
    public String toString() {
        return "User{" +
                "openId='" + openId + '\'' +
                '}';
    }
}
