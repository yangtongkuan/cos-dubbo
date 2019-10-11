package com.cos.common.ann;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
    //
    SysLogType type();

    String title() default "";

    // 描述
    String description() default "";
}
