package sample.model.translate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface NameAnnotation {
    // @NameAnnotations("")のように指定できる
    String value();

    // メソッド名を任意にすると、@NameAnnotations(name = "")のように指定できる
    // 初期値を設定すると省略可能になる。(→初期値がないと必須になる)
    String name() default "";
}
