package com.gupaoedu.vip.damaniProxy.cglibproxy;

import net.sf.cglib.core.DebuggingClassWriter;

import java.beans.Customizer;

/**
 * @Author：zhengqh
 * @date 2020/2/9 16:31
 **/
public class cglibTest {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"D:\\cglib");

        Custemer custemer = (Custemer) new CglibMeipo().getInstance(Custemer.class);
        custemer.findlove();
    }
}
