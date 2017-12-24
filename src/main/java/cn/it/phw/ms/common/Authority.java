package cn.it.phw.ms.common;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface Authority {

    /**
     * 默认验证
     * @return
     */
    AuthorityType value() default AuthorityType.Validate;

}
