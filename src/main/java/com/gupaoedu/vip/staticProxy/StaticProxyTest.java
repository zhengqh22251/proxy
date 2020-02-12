package com.gupaoedu.vip.staticProxy;

/**
 * @Author：zhengqh
 * @date 2020/2/9 11:13
 **/
public class StaticProxyTest {
    public static void main(String[] args) {
        Father father =new Father(new Son());
        father.findlove();
    }
}
