package com.fangda.skylot.mathine.utils;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 启动之后,自动执行一次的类,适用于Tomcat再次启动之后,同步的任务
 */
@Component
public class AutoStartJob implements
        ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            System.out.println("-----所有Bean载入完成---");
        }
    }
}