package com.bluewave.systemmonitor.repository;

import com.bluewave.basic.repository.BaseDao;
import com.bluewave.systemmonitor.entity.SysMonitor;
import org.springframework.stereotype.Repository;

/**
 * @Author: Guosh
 * @Date: 2019-08-23 10:13
 */
@Repository
public interface SysMonitorRepository extends BaseDao<SysMonitor, String>,SysMonitorRepositoryExt{
}
