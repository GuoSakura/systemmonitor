package com.bluewave.systemmonitor.repository.impl;


import com.bluewave.basic.repository.BaseRepositoryExtImpl;
import com.bluewave.systemmonitor.entity.SysMonitor;
import com.bluewave.systemmonitor.repository.SysMonitorRepositoryExt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Guosh
 * @Date: 2019-08-26 10:29
 */
public class SysMonitorRepositoryImpl extends BaseRepositoryExtImpl implements SysMonitorRepositoryExt{

    @Override
    public List<SysMonitor> findDate(int sittingdate) {
        Map<String,Object>param=new HashMap<>();
        param.put("sittingdate",sittingdate);

        return findListObj("SysMonitor.findDate",param,SysMonitor.class);
    }
}
