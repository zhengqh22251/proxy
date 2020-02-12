package com.gupaoedu.vip.damaniProxy.GPproxy;

import java.lang.reflect.Method;

/**
 * @Author：zhengqh
 * @date 2020/2/9 14:37
 **/
public interface GPInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
