package xyz.zzqstudy.service;

import xyz.zzqstudy.entity.Index;
import xyz.zzqstudy.entity.IndexInfo;

import java.util.List;

public interface IndexService {

    /**
     * 通过用户的openId获取股票
     * @param openId
     * @return
     */
    List<IndexInfo> listIndexByUser(String openId);

    /**
     * 删除用户的某一自选股
     * @param openId
     * @param code
     * @return
     */
    int deleteIndexByUser(String openId, String code);

    /**
     * 用户添加自选股
     * @param openId
     * @param code
     * @return
     */
    int insertIndexByUser(String openId, String code);

    /**
     * 列出所有的指数信息
     * @return
     */
    List<IndexInfo> listAllIndex(String openId);

    /**
     * 将某一支股票的所有信息显示出来
     * @return
     */
    List<Index> listAllInformOfIndex(String code, int startIndex);

    /**
     * 模糊查询
     * @param code
     * @return
     */
    List<IndexInfo> listIndexByfuzzySearch(String openId, String code);

    /**
     * 查看openid的用户是否有code作为自选股
     * @param openid
     * @param code
     * @return
     */
    IndexInfo findIndexByUserIdAndCode(String openid, String code);
}
