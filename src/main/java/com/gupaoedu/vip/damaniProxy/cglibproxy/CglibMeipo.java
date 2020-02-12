package com.gupaoedu.vip.damaniProxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

import java.net.ServerSocket;

/**
 * @Author：zhengqh
 * @date 2020/2/9 16:19
 **/
public class CglibMeipo implements MethodInterceptor {
  // zqh
    public  Object getInstance(Class<?> clazz){
        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
         return enhancer.create();
    }
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        bofore();
        Object obj =  methodProxy.invokeSuper(o,objects);
        after();
        return obj;

    }

    private void bofore(){
        System.out.println("我是媒婆，现在给你联系");
    }


    private void after(){
        System.out.println("怎么样？....");
    }
}
