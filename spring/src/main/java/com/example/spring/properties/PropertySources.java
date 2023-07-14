package com.example.spring.properties;

import org.springframework.lang.Nullable;

/**
 * 组合多个PropertySource
 */
public interface PropertySources extends Iterable<PropertySource<?>> {


    boolean contains(String name);

    /**
     * Return the property source with the given name, {@code null} if not found.
     * @param name the {@linkplain org.springframework.core.env.PropertySource#getName() name of the property source} to find
     */
    @Nullable
    PropertySource<?> get(String name);

}
