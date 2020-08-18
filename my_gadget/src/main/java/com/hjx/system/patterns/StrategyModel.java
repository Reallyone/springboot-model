package com.hjx.system.patterns;

import java.lang.reflect.Member;

/**
 * 策略模式：
 * 属于对象的行为模式。其用意是针对一组算法，将每一个算法封装到具有共同接口的独立的类中，从而使得它们可以相互替换。策略模式使得算法可以在不影响到客户端的情况下发生变化。
 *
 * 　策略模式的重心不是如何实现算法，而是如何组织、调用这些算法，从而让程序结构更灵活，具有更好的维护性和扩展性
 * 优点:
 *  策略模式提供了管理相关的算法族的办法。策略类的等级结构定义了一个算法或行为族。恰当使用继承可以把公共的代码移到父类里面，从而避免代码重复。
 *  使用策略模式可以避免使用多重条件(if-else)语句。多重条件语句不易维护，它把采取哪一种算法或采取哪一种行为的逻辑与算法或行为的逻辑混合在一起，统统列在一个多重条件语句里面，比使用继承的办法还要原始和落后
 */
public class StrategyModel {

    //eg:抽象折扣类
    static interface MemberStrategy {
        double calcPrice(double booksPrice);
    }

    //初级会员折扣
    static class PrimaryMemberStrategy implements MemberStrategy {
        @Override
        public double calcPrice(double booksPrice) {
            //初级会员没有折扣
            return booksPrice;
        }
    }


    //中级会员折扣类
    static class IntermediateMemberStrategy implements MemberStrategy {
        @Override
        public double calcPrice(double booksPrice) {
            //初级会员没有折扣
            return booksPrice * 0.9;
        }
    }

    //高级会员折扣类
    static class AdvancedMemberStrategy implements MemberStrategy {
        @Override
        public double calcPrice(double booksPrice) {
            //初级会员没有折扣
            return booksPrice * 0.8;
        }
    }

    //价格类
    static    class Price {
        //持有一个具体的策略对象
        private MemberStrategy strategy;

        /**
         * 构造函数，传入一个具体的策略对象
         *
         * @param strategy 具体的策略对象
         */
        public Price(MemberStrategy strategy) {
            this.strategy = strategy;
        }

        /**
         * 计算图书的价格
         *
         * @param booksPrice 图书的原价
         * @return 计算出打折后的价格
         */
        public double quote(double booksPrice) {
            return this.strategy.calcPrice(booksPrice);
        }
    }



    //客户端
    public static void main(String[] args) {
        //选择并创建需要使用的策略对象
        MemberStrategy memberStrategy = new  AdvancedMemberStrategy();

        //创建环境
        Price price = new Price(memberStrategy);

        double quote = price.quote(300);
        System.out.println("图书的最终价格为：" + quote);

    }

}
