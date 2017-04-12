package testreflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Save {
    String name() default "";
    int order() default -1;
    String[] formats() default {};
    //primitive, immutable(String), enum, aaray
}
