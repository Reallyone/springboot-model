package com.hjx.system.patterns;

/**
 * 工厂模式 model
 */
public class FactoryModel {

    /**
     * 普通工厂模式
     * 创建发送邮件，短信的共同的接口
     */
    interface SendMsg {
        void send();
    }

    //创建实现类， 邮件，短信
    static class EmailSendMsg implements SendMsg {
        @Override
        public void send() {
            System.out.println("this is emailSendMsg");
        }
    }

    static class SmsSendMsg implements SendMsg {
        @Override
        public void send() {
            System.out.println("this is SmsSendMsg");
        }
    }

    //创建一个普通工厂模式
    static class SingleSendFactory {
        SendMsg produce(String type) {
            if ("email".equals(type)) {

                return new EmailSendMsg();
            } else if ("sms".equals(type)) {

                return new SmsSendMsg();
            } else {

                return null;
            }

        }
    }

    //创建多个工厂模式
    static class ManySendFactor{
        SendMsg  sendEmailMsgProduce(){
            return new EmailSendMsg();
        }


        SendMsg  sendSmsMsgProduce(){
            return new EmailSendMsg();
        }

    }

    //创建多个工厂模式
    static class StaticSendFactor{
       static   SendMsg  sendEmailMsgProduce(){
            return new EmailSendMsg();
        }


        static  SendMsg  sendSmsMsgProduce(){
            return new EmailSendMsg();
        }

    }


    public static void main(String[] args) {
        //单个工厂模式
       /* SingleSendFactory sendFactory = new SingleSendFactory();
        SendMsg  singleSendMsg = sendFactory.produce("email");
        singleSendMsg.send();*/

        //多个工厂模式：在普通工厂方法模式中，如果传递的字符串出错，则不能正确创建对象，而多个工厂方法模式是提供多个工厂方法，分别创建对象
        ManySendFactor manySendFactor = new ManySendFactor();
        SendMsg  manySendMsg =  manySendFactor.sendEmailMsgProduce();
        manySendMsg.send();


        //静态工厂模式：就是把多个工厂模式方法改成静态方法，不需要创建实例，直接调用即可
        SendMsg  staticSendMsg =StaticSendFactor.sendEmailMsgProduce();
        staticSendMsg.send();


    }


}
