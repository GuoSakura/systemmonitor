package com.bluewave.systemmonitor.repository;

import com.bluewave.basic.repository.BaseRepositoryExt;
import com.bluewave.systemmonitor.entity.SysMonitor;

import java.util.List;

/**
 * @Author: Guosh
 * @Date: 2019-08-26 10:26
 */
public interface SysMonitorRepositoryExt extends BaseRepositoryExt {

    public List<SysMonitor> findDate(int sittingdate);

}
