package xyz.zzqstudy.service.impl;

import org.springframework.stereotype.Service;
import xyz.zzqstudy.dao.IndexMapper;
import xyz.zzqstudy.entity.Index;
import xyz.zzqstudy.entity.IndexInfo;
import xyz.zzqstudy.service.IndexService;

import javax.annotation.Resource;
import java.util.List;

@Service("indexService")
public class IndexServiceImpl implements IndexService {

    @Resource
    private IndexMapper indexMapper;

    @Override
    public List<IndexInfo> listAllIndex(String openId) {
        List<IndexInfo> indexInfos = indexMapper.listAllIndex(openId);

        return indexInfos;
    }

    @Override
    public List<IndexInfo> listIndexByUser(String openId) {
        return indexMapper.listIndexByUserId(openId);
    }

    @Override
    public int deleteIndexByUser(String openId, String code) {
        return indexMapper.deleteIndexByUserId(openId, code);
    }

    @Override
    public int insertIndexByUser(String openId, String code) {
        return indexMapper.insertIndexByUserId(openId, code);
    }

    @Override
    public List<Index> listAllInformOfIndex(String code, int startIndex) {
        return indexMapper.listIndexInformByCode(code, startIndex);
    }

    @Override
    public List<IndexInfo> listIndexByfuzzySearch(String openId, String code) {
        List<IndexInfo> indexInfos = indexMapper.listIndexByFuzzySearch(code);

        return indexInfos;
    }

    @Override
    public IndexInfo findIndexByUserIdAndCode(String openid, String code) {
        return indexMapper.findIndexByUserIdAndCode(openid, code);
    }
}
