package com.gupaoedu.vip.damaniProxy.GPproxy;


import com.gupaoedu.vip.Person;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author：zhengqh
 * @date 2020/2/9 11:41
 **/
public class Meipo implements GPInvocationHandler {

    private Person target;

    public Object getInstance(Person person) throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        this.target = person;
        Class<?> clazz = target.getClass();
        return GPProxy.newProxyInstance(new GPClassLoader(),target.getClass().getInterfaces(),this);
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
