package com.example.spring.properties.support;

import com.example.spring.properties.PropertySource;
import com.example.spring.properties.PropertySources;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 根据PropertySource的名称获取PropertySource
 */
public class MutablePropertySources implements PropertySources {
    private final List<PropertySource<?>> propertySourceList = new CopyOnWriteArrayList<>();

    @Override
    public boolean contains(String name) {
        return get(name) != null;
    }

    @Override
    public PropertySource<?> get(String name) {
        for (PropertySource<?> propertySource : this.propertySourceList) {
            if (propertySource.getName().equals(name)) {
                return propertySource;
            }
        }
        return null;
    }

    public Iterator<PropertySource<?>> iterator() {
        return this.propertySourceList.iterator();
    }

}
