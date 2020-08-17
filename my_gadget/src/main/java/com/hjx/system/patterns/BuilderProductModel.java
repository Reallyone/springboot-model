package com.hjx.system.patterns;

import lombok.Data;

/**
 * 建造者模式
 *
 *  实现方式：
 *      （1）通过Client、Director、Builder和Product形成的建造者模式
 *
 *      （2）通过静态内部类方式实现零件无序装配话构造
 *
 *
 *  角色：
 *      抽象建造者（builder）：描述具体建造者的公共接口，一般用来定义建造细节的方法，并不涉及具体的对象部件的创建。
 *
 *      具体建造者（ConcreteBuilder）：描述具体建造者，并实现抽象建造者公共接口。
 *
 *      指挥者（Director）：调用具体建造者来创建复杂对象（产品）的各个部分，并按照一定顺序（流程）来建造复杂对象。
 *
 *      产品（Product）：描述一个由一系列部件组成较为复杂的对象。
 *
 *
 */
public class BuilderProductModel {


    //建造者 builder
    static abstract class Builder {
        //地基
        abstract void   buildA();

        //钢筋工程
        abstract void   buildB();

        //铺电线
        abstract void   buildC();

        //粉刷
        abstract void   buildD();

        //完工-获取产品
        abstract Product getProduct();

    }

    @Data
    static class Product {
        private String buildA;
        private String buildB;
        private String buildC;
        private String buildD;

        @Override
        public String toString() {
            return buildA+"\n"+buildB+"\n"+buildC+"\n"+buildD+"\n"+"房子验收完成";
        }

    }

    //具体构建者 -工人
    static class ConcreteBuilder extends Builder {

        private Product product;

        public ConcreteBuilder() {
            product = new Product();
        }

        @Override
        void buildA() {
            product.setBuildA("地基");
        }

        @Override
        void buildB() {
            product.setBuildB("钢筋");
        }

        @Override
        void buildC() {
            product.setBuildC("铺电线");
        }

        @Override
        void buildD() {
             product.setBuildD("粉刷");

        }

        @Override
        Product getProduct() {
            return product;
        }
    }

    //指挥者
    static class Director{
        //指挥工人按顺序造房
        public Product create(Builder builder) {
            builder.buildA();
            builder.buildB();
            builder.buildC();
            builder.buildD();
            return builder.getProduct();
        }
    }


    public static void main(String[] args) {
        Director director = new Director();
        Product create = director.create(new ConcreteBuilder());
        System.out.println(create.toString());
    }




}
