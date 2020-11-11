package com.bluewave.systemmonitor;

import com.bluewave.systemmonitor.entity.SysMonitor;
import com.bluewave.systemmonitor.service.SysMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Guosh
 * @Date: 2019/8/27 17:18
 */

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private SysMonitorService sysMonitorService;

    @RequestMapping("/test1")
    public String finSysMonitor(){
        return "aaaaa";
    }
}
