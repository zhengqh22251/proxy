package com.gupaoedu.vip.damaniProxy.JDKProxy.damaniProxy.JDKProxy;

import com.gupaoedu.vip.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author：zhengqh
 * @date 2020/2/9 11:41
 **/
public class JDKMeipo implements InvocationHandler {

    private Person target;

    public Object getInstance(Person person) {
        this.target = person;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),target.getClass().getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        bofore();
        Object obj =method.invoke(this.target,args);
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
