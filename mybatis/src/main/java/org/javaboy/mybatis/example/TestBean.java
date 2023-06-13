package org.javaboy.mybatis.example;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

/**
 * @author majin.wj
 * @date 2023/6/9 4:52 PM
 * @desc
 */
@Component
public class TestBean {

    @Autowired
    AMapper aMapper;


    @PostConstruct
    public void test(){
       /* PageHelper.startPage(1,1);
        List<A> as = aMapper.selectByScore(10);
        System.out.println(as.getClass());
        System.out.println(Arrays.asList(as));

        PageInfo<A> pageInfo = new PageInfo<>(as);
        System.out.println(pageInfo);*/
        List<A> select = aMapper.select(10);
        System.out.println(select);
    }

}
