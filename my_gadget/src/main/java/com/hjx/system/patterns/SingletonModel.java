package com.hjx.system.patterns;

/**
 * 单例模式：
 * 单例对象（Singleton）是一种常用的设计模式。在Java应用中，单例对象能保证在一个JVM中，该对象只有一个实例存在。这样的模式有几个好处：
 * 1、某些类创建比较频繁，对于一些大型的对象，这是一笔很大的系统开销。
 * <p>
 * 2、省去了new操作符，降低了系统内存的使用频率，减轻GC压力。
 * <p>
 * 3、有些类如交易所的核心交易引擎，控制着交易流程，如果该类可以创建多个的话，系统完全乱了。（比如一个军队出现了多个司令员同时指挥，肯定会乱成一团），所以只有使用单例模式，才能保证核心交易服务器独立控制整个流程。
 */
public class SingletonModel {

    //单例模式 --饿汉式  -- 造成资源浪费
    static class SingletonHungry {
        //类加载的时候就创建
        final static SingletonHungry instance = new SingletonHungry();

        //私有化后构造器，防止外界创建对象
        private SingletonHungry() {
        }

        //提供外界获取对象的方法
        public static SingletonHungry getInstance() {
            return instance;
        }

    }


    //单例模式 --懒汉式  --高并发情况下线程不安全，如果加上synchronized来解决的话性能问题有问题
    static class SingletonLazy {
        //需要对象的时候才去创建
        final static SingletonLazy instance = null;

        //私有化后构造器，防止外界创建对象
        private SingletonLazy() {
        }

        //提供外界获取对象的方法：  可以synchronized 加锁来保证线程安全
        public SingletonLazy getInstance() {
            if (instance == null) {
                return new SingletonLazy();
            }
            return instance;
        }

    }

    //单例模式 --静态内部类
    static class Singleton {

        //私有化后构造器，防止外界创建对象
        private Singleton() {
        }

        //静态内部类，只在getInstance方法内使用
        private static class SingletonHolder {
            public static Singleton instance = new Singleton();
        }

        //返回接口
        public static Singleton getInstance() {
            return SingletonHolder.instance;
        }

    }


}
