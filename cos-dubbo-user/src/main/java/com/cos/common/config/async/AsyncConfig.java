package com.cos.common.config.async;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2019/8/11 21:13
 * @To change this template use File | Settings | File Templates.
 */
@ConfigurationProperties(prefix = "spring.task.pool")
@Component
@Data
public class AsyncConfig {

    private int corePoolSize;

    private int maxPoolSize;

    private int keepAliveSeconds;

    private int queueCapacity;
}
