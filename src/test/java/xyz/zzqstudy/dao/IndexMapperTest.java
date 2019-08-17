package xyz.zzqstudy.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.zzqstudy.entity.Index;
import xyz.zzqstudy.entity.IndexInfo;
//import xyz.zzqstudy.service.IndexService;

import java.io.IOException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})

public class IndexMapperTest {

    @Autowired()
    private IndexMapper indexMapper;

    @Before
    public void init() throws IOException {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        indexMapper = (IndexMapper) context.getBean("indexMapper");
    }

    @After
    public void destory() throws IOException {

    }

    @Test
    public void selectAllIndexTest(){
        System.out.println(indexMapper);
        List<IndexInfo> list = indexMapper.listAllIndex("1234567");
        for (IndexInfo i: list){
            System.out.println(i);
        }

//        System.out.println(indexMapper.findIndexByUserIdAndCode("1234567", "399002"));
    }

    @Test
    public void selectIndexByUserIdTest(){
        List<IndexInfo> list = indexMapper.listIndexByUserId("1234567");
        for (IndexInfo index: list){
            System.out.println(index);
        }
    }

    @Test
    public void selectIndexInformByCodeTest(){
        List<Index> list = indexMapper.listIndexInformByCode("000001", 5);
        for (Index index: list){
            System.out.println(index);
        }
    }

    @Test
    public void insertIndexTest(){
        int result = indexMapper.insertIndexByUserId("1234567", "000003");
        System.out.println(result);
    }

    @Test
    public void fuzzySearchTest(){
        List<IndexInfo> list = indexMapper.listIndexByFuzzySearch("001");
        for (IndexInfo info: list){
            System.out.println(info);
        }
    }
}
