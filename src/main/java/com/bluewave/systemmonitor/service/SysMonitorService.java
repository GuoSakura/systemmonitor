package com.bluewave.systemmonitor.service;

import com.bluewave.basic.service.BaseService;
import com.bluewave.systemmonitor.entity.SysMonitor;
import org.hyperic.sigar.SigarException;

import java.util.List;

/**
 * @Author: Guosh
 * @Date: 2019-08-23 10:15
 */
public interface SysMonitorService extends BaseService<SysMonitor,String> {
    public void saveSysMonitor () throws SigarException;

    public List<SysMonitor> findDate(int sittingdate);
}
