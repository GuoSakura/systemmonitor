package com.bluewave.systemmonitor;



import com.bluewave.basic.repository.SqlMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties(SqlMap.class)
public class SystemApplication {
    public static void main(String[] args) {
    	SpringApplication.run(SystemApplication.class,args);
    }

}
