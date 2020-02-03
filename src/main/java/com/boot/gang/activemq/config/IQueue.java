package com.boot.gang.activemq.config;

import javax.jms.Queue;

/**
 * @desciption:
 * @author:shengyong
 * @Date:2020/1/3 11:12
 */
public interface IQueue {
    Queue createQueue();
}
