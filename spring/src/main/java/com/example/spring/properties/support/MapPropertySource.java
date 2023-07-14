package com.example.spring.properties.support;

import com.example.spring.properties.EnumerablePropertySource;
import org.springframework.util.StringUtils;

import java.util.Map;

public class MapPropertySource extends EnumerablePropertySource<Map<String,Object>> {


    /**
     * Create a new {@code PropertySource} with the given name and source object.
     *
     * @param name   the associated name
     * @param source the source object
     */
    public MapPropertySource(String name, Map<String,Object> source) {
        super(name, source);
    }

    @Override
    public String[] getPropertyNames() {
        return StringUtils.toStringArray(this.getSource().keySet());
    }

    @Override
    public boolean containsProperty(String name) {
        return this.getSource().containsKey(name);
    }

    @Override
    public Object getProperty(String name) {
        return this.getSource().get(name);
    }
}
