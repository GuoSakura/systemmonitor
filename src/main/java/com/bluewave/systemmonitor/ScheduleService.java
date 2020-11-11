package com.bluewave.systemmonitor;

import com.bluewave.systemmonitor.entity.SysMonitor;
import com.bluewave.systemmonitor.service.SysMonitorService;
import com.bluewave.systemmonitor.util.SigarUtil;
import org.apache.commons.io.FileUtils;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @Author: Guosh
 * @Date: 2019-08-22 17:39
 */

@Component
@EnableScheduling
public class ScheduleService {

    @Value("${settingdate}")
    private int settingdate;

    @Autowired
    private SysMonitorService sysMonitorService;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(cron = "${timer.systemmonitortime}")
    public void SystemMonitorTime() throws InterruptedException, SigarException, IOException {

        System.out.println(String.format("当前执行时间为：%s",dateFormat.format(new Date())));

        try {
            sysMonitorService.saveSysMonitor();
            SigarUtil.property();
            SigarUtil.memory();
            SigarUtil.cpu();
            SigarUtil.file();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Scheduled(cron = "${timer.systemmonitortimecron}")
    public void SystemMonitorTimeCron() throws InterruptedException, SigarException, IOException {

        System.out.println(String.format("当前执行时间为：%s",dateFormat.format(new Date())));

        List<SysMonitor> sysMonitors = sysMonitorService.findDate(settingdate);

        for (SysMonitor sysMonitor: sysMonitors) {
            sysMonitorService.delete(sysMonitor);
        }

    }

}
