package com.example.spring.properties;

/**
 * 对外提供接口，用来获取配置
 */
public interface PropertyResolver {


    boolean containsProperty(String key);

    String getProperty(String key);

    <T> T getProperty(String key, Class<T> targetType);




}
