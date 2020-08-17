package com.hjx.system.patterns;


/**
 * 抽象工厂模式
 */
public class AbstractFactoryModel {

    public interface Provider {
          FactoryModel.SendMsg produce();
    }

    //创建实现类， 邮件，短信
    static class EmailSendMsg implements FactoryModel.SendMsg {
        @Override
        public void send() {
            System.out.println("this is emailSendMsg");
        }
    }

    static class SmsSendMsg implements FactoryModel.SendMsg {
        @Override
        public void send() {
            System.out.println("this is SmsSendMsg");
        }
    }


    static class SendMailFactory implements Provider {

        @Override
        public FactoryModel.SendMsg produce() {
            return new EmailSendMsg();
        }
    }

    static class SendSmsMsgFactory implements Provider {

        @Override
        public FactoryModel.SendMsg produce() {
            return new SmsSendMsg();
        }
    }


    public static void main(String[] args) {
        //抽象工厂模式： 这个模式的好处就是，如果你现在想增加一个功能：发及时信息，
        //         则只需做一个实现类，实现Sender接口，同时做一个工厂类，实现Provider接口，就OK了，无需去改动现成的代码。这样做，拓展性较好！
        Provider provider = new SendMailFactory();
        provider.produce().send();

        Provider sendSmsMsgFactory = new SendSmsMsgFactory();
        sendSmsMsgFactory.produce().send();

    }

}
