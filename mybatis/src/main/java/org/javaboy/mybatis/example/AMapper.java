package org.javaboy.mybatis.example;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author majin.wj
 * @date 2023/5/4 9:55 PM
 * @desc
 */
public interface AMapper {

    List<A> selectByScore(int score);

    int addOne(A a);


    /*不需要映射的sql语句，直接使用注解即可*/
    @Select("select * from a where score= #{score}")
    List<A> select(int score);

}
