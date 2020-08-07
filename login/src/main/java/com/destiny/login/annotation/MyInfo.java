package com.destiny.login.annotation;

import java.lang.annotation.*;

/**
 * 切面注解demo
 *
 * @author l_xj <l_xj@winning.com.cn>
 * @date 2020/8/5 16:58
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MyInfo {

}
