package com.example.spring.properties;

import org.springframework.util.ObjectUtils;

public abstract class EnumerablePropertySource<T> extends PropertySource<T> {
    /**
     * Create a new {@code PropertySource} with the given name and source object.
     *
     * @param name   the associated name
     * @param source the source object
     */
    public EnumerablePropertySource(String name, T source) {
        super(name, source);
    }


    @Override
    public boolean containsProperty(String name) {
        return ObjectUtils.containsElement(getPropertyNames(), name);
    }

    public abstract String[] getPropertyNames();
}
