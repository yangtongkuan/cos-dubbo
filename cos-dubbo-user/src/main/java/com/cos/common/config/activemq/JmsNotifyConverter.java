package com.cos.common.config.activemq;//package com.cos.cloud.config.activemq;
//
//import org.springframework.jms.support.converter.MessageConversionException;
//import org.springframework.jms.support.converter.MessageConverter;
//import org.springframework.jms.support.converter.SimpleMessageConverter;
//
//import javax.jms.JMSException;
//import javax.jms.Message;
//import javax.jms.ObjectMessage;
//import javax.jms.Session;
//import java.io.Serializable;
//
///**
// * Created with IntelliJ IDEA.
// *
// * @User: @Created by yangtk
// * @Date: @Date 2019/8/9 15:01
// * @Classname: JmsNotifyConverter
// * @To change this template use File | Settings | File Templates.
// */
//public class JmsNotifyConverter implements MessageConverter {
//    @Override
//    public Message toMessage(Object o, Session session) throws JMSException, MessageConversionException {
//        return session.createObjectMessage((Serializable) o);
//    }
//
//    @Override
//    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
//        ObjectMessage objMessage = (ObjectMessage) message;
//        return objMessage.getObject();
//    }
//}
