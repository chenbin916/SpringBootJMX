package com.bin.study.jmx.opratorother.tools;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;
import org.springframework.jmx.export.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@ManagedResource(objectName = "chenbin.study.jmx:name=changeLogLevelTools")//暴露为MBean
@Component
public class ChangeLogLevel {

    private final static org.slf4j.Logger log = LoggerFactory.getLogger(ChangeLogLevel.class);


    @ManagedOperation
    @ManagedOperationParameters({@ManagedOperationParameter(name = "className", description = "para className"), @ManagedOperationParameter(name = "level", description = "para level")})
    public String changeLevel(String className, int level) {
        String res = "";
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();

        if (null == className || "".equalsIgnoreCase(className))
            return "set failure,className is null";
        ch.qos.logback.classic.Logger vlogger = context.getLogger(className);

        if ("root".equalsIgnoreCase(className))
            res = "cann't set root level";
        else {

            res = "原来级别：" + vlogger.getLevel();
            vlogger.setLevel(Level.toLevel(level));
            log.info("更改了" + className + "的日志级别");
            res = res + "更改后的级别为：" + vlogger.getLevel();


        }
        //List<Logger> loggerList = context.getLoggerList();
       // for (ch.qos.logback.classic.Logger log : loggerList)
          //  log.info(log.getName() + "level is :" + log.getLevel()); //默认都是没有值得，只有root才有。因为logback-spring.xml没有配置
        return res;
    }
}
