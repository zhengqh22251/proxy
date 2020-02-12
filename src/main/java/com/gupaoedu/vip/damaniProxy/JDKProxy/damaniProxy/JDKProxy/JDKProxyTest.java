package com.gupaoedu.vip.damaniProxy.JDKProxy.damaniProxy.JDKProxy;

import com.gupaoedu.vip.Girl;
import com.gupaoedu.vip.Person;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * @Author：zhengqh
 * @date 2020/2/9 11:49
 **/
public class JDKProxyTest {
    public static void main(String[] args) {
        /*给girl找对象*/
        Person obj = (Person) new JDKMeipo().getInstance(new Girl());
        /*obj.findlove();*/
        /*给妇女找对象*/
       /* Person obj = (Person) new JDKMeipo().getInstance(new Funv());
        obj.findlove();*/

       //反编译出来看看
        byte bytes[] = ProxyGenerator.generateProxyClass("$proxy0",new Class[]{Person.class});
        try {
            FileOutputStream os = new FileOutputStream("D://proxy0.class");
            os.write(bytes);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
