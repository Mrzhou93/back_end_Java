package xyz.zzqstudy.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import xyz.zzqstudy.entity.User;

@Repository
public interface UserMapper {
    /**
     * 根据用户的openid查询用户是否存在
     * @param openid
     * @return
     */
    @Select("select * from user where openid = #{openid}")
    User getUserById(String openid);

    /**
     * 新增用户
     * @param user
     * @return
     */
    @Insert("insert into user values(#{openId})")
    int insertUser(User user);

}
