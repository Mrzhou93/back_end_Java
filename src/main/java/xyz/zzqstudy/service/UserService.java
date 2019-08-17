package xyz.zzqstudy.service;

public interface UserService {

    /**
     * 对用户信息进行检查，并且更新
     * @param openId
     */
    void checkUser(String openId);
}
