package me.ronyvidaur.todorest.util;

import java.util.HashMap;
import java.util.Map;

public class ResponseBuilder {
    private static HashMap properties;

    private ResponseBuilder() {}

    public static void init() {
        properties = new HashMap();
    }

    public static void addProperty(String name, Object content) {
        properties.put(name, content);
    }

    public static void setSuccess(boolean x) {
        properties.put("success", x);
    }

    public static void setData(Object data) {
        properties.put("data", data);
    }

    public static void setPath(Object path) {
        properties.put("path", path);
    }

    public static void setBaseProperties(Object data, boolean success, Object path) {
        properties.put("data", data);
        properties.put("success", success);
        properties.put("path", path);
    }

    public static Map build() {
        return properties;
    }

}
