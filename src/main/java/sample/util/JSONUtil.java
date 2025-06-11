package sample.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class JSONUtil {
    private static ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static JsonMapper JSON_MAPPER = new JsonMapper();
    public static <T> T toObject(String json, Class<T> clazz) throws JsonProcessingException {
        return OBJECT_MAPPER.readValue(json, clazz);
    }

    public static String toJson(Object obj) throws JsonProcessingException {
        return JSON_MAPPER.writeValueAsString(obj);
    }
}
