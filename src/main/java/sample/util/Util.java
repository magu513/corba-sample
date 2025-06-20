package sample.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.apache.cxf.common.util.StringUtils;
import sample.model.translate.NameAnnotation;
import sample.model.translate.TargetAnnotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Util {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final JsonMapper JSON_MAPPER = new JsonMapper();

    public static <T> T toObject(String json, Class<T> clazz) throws JsonProcessingException {
        return OBJECT_MAPPER.readValue(json, clazz);
    }

    public static String toJson(Object obj) throws JsonProcessingException {
        return JSON_MAPPER.writeValueAsString(obj);
    }

    public static Object translate(Object obj) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazz = obj.getClass();
        // クラスレベルのアノテーション取得
        TargetAnnotation targetAnnotation = clazz.getAnnotation(TargetAnnotation.class);
        if (targetAnnotation == null) return null;
        Class<?> targetClass = targetAnnotation.value();
        Field[] fields = clazz.getDeclaredFields();
        // クラスからインスタンスの生成
        Object target = targetClass.getDeclaredConstructor().newInstance();
        for (Field f : fields) {
            // フィールドレベルのアノテーションを取得
            NameAnnotation nameAnnotation = f.getAnnotation(NameAnnotation.class);

            if (nameAnnotation == null) continue;

            String fieldName = nameAnnotation.value();
            // メソッドの取得はもっとよい方法があるかも
            // StringUtils.capitalizeは先頭を大文字にする。→ ライブラリが使えないのであれば自前で実装する必要があるかも
            // 安全性のために、getter/setterを使用し値の取得/設定を行う
            // field.setで直接代入でもいい。privateの場合は、事前にf.setAccessible(true)する
            Method getter = clazz.getDeclaredMethod("get" + StringUtils.capitalize(f.getName()));
            Object sourceValue = getter.invoke(obj);
            Method setter = target.getClass().getDeclaredMethod("set" + StringUtils.capitalize(fieldName), f.getType());
            setter.invoke(target, sourceValue);
        }

        return target;
    }


}
