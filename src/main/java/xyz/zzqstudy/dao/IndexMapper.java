package xyz.zzqstudy.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import xyz.zzqstudy.entity.Index;
import xyz.zzqstudy.entity.IndexInfo;

import java.util.List;

@Repository
public interface IndexMapper {
    /**
     * 选择出所有的index的代码以及名称
     * @return
     */
//    @Select("select code, name from index_list")
    @Select("select code, name, IF(code in(select code from user_stock where openid=#{openId}), true , false) as isSelect from index_list;")
    List<IndexInfo> listAllIndex(@Param("openId") String openId);

    /**
     * 根据用户的openid，选择出对应用户的自选股
     * @param openid
     * @return
     */
    @Select("select user_stock.code, name from user_stock, index_list " +
            "where user_stock.code=index_list.code and openid=#{openid}")
    List<IndexInfo> listIndexByUserId(String openid);

    /**
     * 通过股票代码模糊查询
     * @param code
     * @return
     */
    @Select("select * from index_list where code like '%${code}%'")
    List<IndexInfo> listIndexByFuzzySearch(@Param("code") String code);

    /**
     * 根据股票的code，选择出股票的所有信息
     * @param code
     * @return
     */
    @Select("select * from index_data_${code} order by date desc limit #{num}, 10")
    List<Index> listIndexInformByCode(@Param("code") String code,
                                      @Param("num") int num);

    /**
     * 用户新增自选股
     * @param openid
     * @param code
     * @return
     */
    @Insert("insert into user_stock values(#{openid}, #{code})")
    int insertIndexByUserId(@Param("openid") String openid, @Param("code") String code);

    /**
     * 用户删除自选股
     * @param openid
     * @param code
     * @return
     */
    @Delete("delete from user_stock where openid=#{openid} and code=#{code}")
    int deleteIndexByUserId(@Param("openid") String openid, @Param("code") String code);

    /**
     * 通过openid和code查看用户是否将code设置为自选股
     * @param openid
     * @param code
     * @return
     */
    @Select("select * from user_stock where openid=#{openid} and code=#{code}")
    IndexInfo findIndexByUserIdAndCode(@Param("openid") String openid, @Param("code") String code);
}
