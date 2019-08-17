package xyz.zzqstudy.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.zzqstudy.entity.IndexInfo;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})

public class IndexServiceTest {

    @Autowired
    private IndexService indexService;

//    @Before
//    public void before(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        indexService = context.getBean("indexService", IndexService.class);
//    }

    @Test
    public void fuzzySearch(){
        System.out.println(indexService);
        List<IndexInfo> list = indexService.listIndexByfuzzySearch("1234567", "001");
        for (IndexInfo info: list){
            System.out.println(info);
        }
    }

    @Test
    public void listAllInfo(){
        List<IndexInfo> list = indexService.listAllIndex("1234567");
        for (IndexInfo info: list){
            System.out.println(info);
        }
    }
}
