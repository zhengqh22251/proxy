package com.gupaoedu.vip.damaniProxy.GPproxy;


import com.gupaoedu.vip.Girl;
import com.gupaoedu.vip.Person;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author：zhengqh
 * @date 2020/2/9 11:49
 **/
public class GPProxyTest {
    public static void main(String[] args) {
        /*给girl找对象*/
        Person obj = null;
        try {
            obj = (Person) new Meipo().getInstance(new Girl());
        } catch (Exception e) {
            e.printStackTrace();
        }
        obj.findlove();
    }
}
