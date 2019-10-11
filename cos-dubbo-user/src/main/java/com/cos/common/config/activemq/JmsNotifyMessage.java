package com.cos.common.config.activemq;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2019/8/9 14:43
 * @Classname: JmsNotifyMessage
 * @To change this template use File | Settings | File Templates.
 */
@Data
@Accessors(chain = true)
public class JmsNotifyMessage implements Serializable {
    private String code;
    private String message;
}
