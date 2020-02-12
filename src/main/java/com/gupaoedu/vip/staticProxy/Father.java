package com.gupaoedu.vip.staticProxy;

import com.gupaoedu.vip.Person;

/**
 * @Author：zhengqh
 * @date 2020/2/9 11:11
 **/
public class Father implements Person {

    private Person person;

    public Father(Person person) {
        this.person = person;
    }


    public void findlove() {
        this.person.findlove();
        System.out.println("父亲物色");
        System.out.println("儿子makelove");
    }
}
