package xyz.zzqstudy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.zzqstudy.entity.Index;
import xyz.zzqstudy.entity.IndexInfo;
import xyz.zzqstudy.service.IndexService;
import xyz.zzqstudy.service.UserService;

import java.util.List;

//  /index/**
@RestController
//@RequestMapping("/index")
public class IndexController {

    private static Logger log = LoggerFactory.getLogger(IndexController.class);

    @Autowired()
    private IndexService indexService;

    @Autowired()
    private UserService userService;

    //      /listAllIndex?openId=open1234567
    @RequestMapping(value = "/listAllIndex", method = RequestMethod.GET)
    public List<IndexInfo> listAllIndex(@RequestParam("openId") String openId){
        userService.checkUser(openId);

        List<IndexInfo> list = indexService.listAllIndex(openId);

        return list;
    }

    // /listIndexByOpenId?openId=1234567
    @RequestMapping(value = "/listIndexByOpenId", method = RequestMethod.GET)
    public List<IndexInfo> listIndexByUser(@RequestParam("openId") String openId){
        List<IndexInfo> list = indexService.listIndexByUser(openId);

        return list;
    }

    // /deleteIndexByUser?openId=1234567&code=399002
    @RequestMapping(value = "/deleteIndexByUser", method = RequestMethod.POST)
    public int deleteIndexByUser(@RequestParam("openId") String openId,
                                 @RequestParam("code") String code){
        IndexInfo info = indexService.findIndexByUserIdAndCode(openId, code);
        if (info == null){
            return 0;
        } else {
            indexService.deleteIndexByUser(openId, code);
            return 1;
        }
    }

    //      /insertIndexByUser?openId=1234567&code=399002
    @RequestMapping(value = "/insertIndexByUser", method = RequestMethod.POST)
    public int insertIndexByUser(@RequestParam("openId") String openId,
                                 @RequestParam("code") String code){
        IndexInfo info = indexService.findIndexByUserIdAndCode(openId, code);
        if (info == null){
            indexService.insertIndexByUser(openId, code);
            return 1;
        } else {
            return 0;
        }
    }

    //      /listAllInformOfIndex?code=000001
    @RequestMapping(value = "/listAllInformOfIndex", method = RequestMethod.GET)
    public List<Index> listAllInformOfIndex(@RequestParam("code") String code,
                                            @RequestParam("startIndex") int startIndex){
        List<Index> list = indexService.listAllInformOfIndex(code, startIndex);
        return list;
    }


    //      /listIndexByFuzzySearch?openId=1234567&code=001
    @RequestMapping(value = "/listIndexByFuzzySearch", method = RequestMethod.GET)
    public List<IndexInfo> listIndexByFuzzySearch(@RequestParam("openId") String openId,
                                                  @RequestParam("code") String code){
        List<IndexInfo> list = indexService.listIndexByfuzzySearch(openId, code);
        return list;
    }
}