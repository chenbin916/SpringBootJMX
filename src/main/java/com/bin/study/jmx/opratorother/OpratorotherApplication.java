package com.bin.study.jmx.opratorother;

import com.bin.study.jmx.opratorother.controller.JmxController;
import com.bin.study.jmx.opratorother.tools.ChangeLogLevel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

@SpringBootApplication
public class OpratorotherApplication {

    public static void main(String[] args) {

        SpringApplication.run(OpratorotherApplication.class, args);

    }

}
