package jp.co.sample.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    private ObjectMapper mapper;

    public JsonUtil() {
        this.mapper = new ObjectMapper();
    }

    public static JsonUtil use() {
        return new JsonUtil();
    }

    public <T> T string2bean(String content, Class<T> valueType) {
        try {
            return mapper.readValue(content, valueType);
        } catch (Exception e) {
            return null;
        }
    }

    public String bean2string(Object bean) {
        try {
            return mapper.writeValueAsString(bean);
        } catch (Exception e) {
            return null;
        }
    }

}
