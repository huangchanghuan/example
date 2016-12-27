package com.gao.thinking.proxy.typeInformation.theClassObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 加载类,静态方法,构造函数也是静态方法
 *
 * @Author 黄昌焕
 * @Date 2016-12-20  13:45
 */
public class SweetShop {
    private final static Logger logger = LoggerFactory.getLogger(SweetShop.class);

    /**
     * 1.in the process of loading,Gum's static clause is executed.but structure will not be executed.
     * 2.if Gum is already loaded,what will happen? it will not load again and static clause will not execute again.
     *
     * @param args
     */
    public static void main(String[] args){
        try {
            System.out.println("first:");
            Class.forName("com.gao.thinking.proxy.typeInformation.theClassObject.Gum");
            System.out.println("second:");
            Class.forName("com.gao.thinking.proxy.typeInformation.theClassObject.Gum");
            System.out.println("third:");
            Class.forName("com.gao.thinking.proxy.typeInformation.theClassObject.Gum").newInstance();
        } catch (ClassNotFoundException e) {
            logger.error("error when loading class!");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            logger.error("error when newInstance!");
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

}

class Gum {
    public Gum(){
        System.out.println("construct:Gum");
    }
    static {
        System.out.println("static:Loading Gum");
    }
}
class Candy{
    static {
        System.out.println("Loading Candy");
    }
}
class Cookie{
    static {
        System.out.println("Loading Cookie");
    }
}