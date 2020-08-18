package com.hjx.system.patterns;

/**
 * 适配器模式
 * 　 把一个类的接口变换成客户端所期待的另一种接口，从而使原本因接口不匹配而无法在一起工作的两个类能够在一起工作
 * 角色：
 * 目标角色:这就是所期待得到的接口。注意：由于这里讨论的是类适配器模式，因此目标不可以是类
 * 源角色:现在需要适配的接口
 * 适配器角色: 适配器类是本模式的核心。适配器把源接口转换成目标接口。显然，这一角色不可以是接口，而必须是具体类
 */
public class AdaptationModel {

    interface Target {
        /**
         * 这是源类Adaptee 也有的方法
         */
        public void sampleOperation1();

        /**
         * 这是源类Adaptee 没有的方法
         */
        public void sampleOperation2();
    }


    class Adaptee {
        public void sampleOperation1() {
        }
    }

    //继承了Target 才会用sampleOperation2()的方法
    class Adapter extends Adaptee implements Target {
        @Override
        public void sampleOperation2() {

        }
    }




}
