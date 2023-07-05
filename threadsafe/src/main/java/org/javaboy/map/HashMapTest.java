package org.javaboy.map;

import java.util.HashMap;

/**
 * HashMap默认初始化容量是16.负载因子0.75。当存储元素数量超过了容量*负载因子进行扩容；
 * 所以在设置初始化容量的时候，可以将容量设置成 存储个数/0.75 + 1. 这样就可以避免扩容；
 *
 *
 *
 * hashcode理论上是唯一的，但是存在自己重写hashcode情况；
 */
public class HashMapTest {
    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>(16);

        map.put("zs","nan");

        map.get("zs");


    }
}
