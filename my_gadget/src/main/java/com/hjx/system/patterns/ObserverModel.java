package com.hjx.system.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式：
 * 在对象之间定义了一对多的依赖，这样一来，当一个对象改变状态，依赖它的对象会收到通知并自动更新。
 * 其实就是发布订阅模式，发布者发布信息，订阅者获取信息，订阅了就能收到信息，没订阅就收不到信息
 */
public class ObserverModel {

    /***
     * 抽象观察者
     * 定义了一个update()方法，当被观察者调用notifyObservers()方法时，观察者的update()方法会被回调。
     *
     */
    interface Observer {
        void update(String message);
    }

    /***
     * 抽象被观察者接口
     * 声明了添加、删除、通知观察者方法
     *
     */
    interface Observerable {

        void registerObserver(Observer o);

        void removeObserver(Observer o);

        void notifyObserver();
    }

    /**
     * 被观察者，也就是微信公众号服务
     * 实现了Observerable接口，对Observerable接口的三个方法进行了具体实现
     */
    static class WechatServer implements Observerable {

        //注意到这个List集合的泛型参数为Observer接口，设计原则：面向接口编程而不是面向实现编程
        private List<Observer> list;
        private String message;

        WechatServer() {
            list = new ArrayList<Observer>();
        }

        @Override
        public void registerObserver(Observer o) {
            list.add(o);
        }

        @Override
        public void removeObserver(Observer o) {
            if (!list.isEmpty())
                list.remove(o);
        }

        @Override
        public void notifyObserver() {
            for (int i = 0; i < list.size(); i++) {
                Observer oserver = list.get(i);
                oserver.update(message);
            }
        }

        public void setInfomation(String s) {
            this.message = s;
            System.out.println("微信服务更新消息： " + s);
            //消息更新，通知所有观察者
            notifyObserver();
        }
    }


    //定义具体观察者，微信公众号的具体观察者为用户User
    static class User implements Observer {
        private String name;

        private String message;

        public User(String name) {
            this.name = name;
        }

        @Override
        public void update(String message) {
            this.message = message;
            read();
        }

        void read() {
            System.out.println(name + " 收到推送消息： " + message);
        }
    }

    public static void main(String[] args) {
        WechatServer server = new WechatServer();

        Observer userZhang = new User("ZhangSan");
        Observer userLi = new User("LiSi");
        Observer userWang = new User("WangWu");

        server.registerObserver(userZhang);
        server.registerObserver(userLi);
        server.registerObserver(userWang);
        server.setInfomation("PHP是世界上最好用的语言！");

        System.out.println("--------------------张三取消订阅--------------------------");
        server.removeObserver(userZhang);
        server.setInfomation("JAVA是世界上最好用的语言！");

        System.out.println("--------------------张三又订阅--------------------------");
        server.registerObserver(userZhang);
        server.setInfomation("C#是世界上最好用的语言！");
    }


}
