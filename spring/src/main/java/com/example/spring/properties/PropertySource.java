package com.example.spring.properties;

import org.springframework.util.Assert;

/**
 * 范型是用来存放属性的容器；
 *
 * @param <T>
 */
public abstract class PropertySource<T> {
    private final String name;

    private final T source;

    /**
     * Create a new {@code PropertySource} with the given name and source object.
     *
     * @param name   the associated name
     * @param source the source object
     */
    public PropertySource(String name, T source) {
        Assert.hasText(name, "Property source name must contain at least one character");
        Assert.notNull(source, "Property source must not be null");
        this.name = name;
        this.source = source;
    }

    /**
     * 子类重写，可以修改方法的返回值
     *
     * @param name
     * @return
     */
    public abstract Object getProperty(String name);

    public boolean containsProperty(String name) {
        return getProperty(name) != null;
    }

    public String getName() {
        return name;
    }

    public T getSource() {
        return source;
    }
}
