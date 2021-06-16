package club.machine.features.module;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ModuleData {
    String name();

    Category category() default Category.Misc;

    int defaultKeyBind() default 0;
}
