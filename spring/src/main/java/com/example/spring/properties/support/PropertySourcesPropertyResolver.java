package com.example.spring.properties.support;

import com.alibaba.fastjson.JSON;
import com.example.spring.properties.PropertyResolver;
import com.example.spring.properties.PropertySource;

public class PropertySourcesPropertyResolver implements PropertyResolver {

    private MutablePropertySources propertySources;

    public PropertySourcesPropertyResolver(MutablePropertySources propertySources) {
        this.propertySources = propertySources;
    }

    @Override
    public boolean containsProperty(String key) {
        if (propertySources != null) {
            for (PropertySource<?> propertySource : propertySources) {
                if (propertySource.containsProperty(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getProperty(String key) {
        return getProperty(key, String.class);
    }

    @Override
    public <T> T getProperty(String key, Class<T> targetType) {
        if (propertySources != null) {
            for (PropertySource<?> propertySource : propertySources) {
                Object value = propertySource.getProperty(key);
                String str = JSON.toJSONString(value);
                return JSON.parseObject(str, targetType);
            }
        }
        return null;
    }
}
