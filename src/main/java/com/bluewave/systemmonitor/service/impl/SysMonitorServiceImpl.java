package com.bluewave.systemmonitor.service.impl;

import com.bluewave.basic.service.impl.BaseServiceImpl;
import com.bluewave.systemmonitor.entity.SysDisk;
import com.bluewave.systemmonitor.entity.SysMonitor;
import com.bluewave.systemmonitor.repository.SysMonitorRepository;
import com.bluewave.systemmonitor.service.SysMonitorService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.hyperic.sigar.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * @Author: Guosh
 * @Date: 2019-08-23 10:18
 */
@Service
@Transactional
public class SysMonitorServiceImpl extends BaseServiceImpl<SysMonitor,String> implements SysMonitorService  {
    @Autowired
    private SysMonitorRepository sysMonitorRepository;

    @Override
    public void saveSysMonitor() throws SigarException {
        SysMonitor sysMonitor=new SysMonitor();

        Properties props = System.getProperties();
        Sigar sigar = new Sigar();
        //操作系统
        sysMonitor.setOperatSystem(props.getProperty("os.name"));


        Mem mem = sigar.getMem();

        //总内存M
        sysMonitor.setTotalMemory(mem.getTotal() / 1024L/1024L);

        //使用内存M
        sysMonitor.setUsedMemory(mem.getUsed()/1024L/1024L);

        //剩余内存
        sysMonitor.setLeftMemory(mem.getFree()/1024L/1024L);

        //处理器个数
        CpuInfo infos[] = sigar.getCpuInfoList();
        sysMonitor.setProcessNum(infos.length);


        //CPU占有率
        CpuPerc perc = sigar.getCpuPerc();
        sysMonitor.setCpuUsed(CpuPerc.format(perc.getCombined()));
        //CPU空闲率
        sysMonitor.setCpuFreed(CpuPerc.format(perc.getIdle()));


        //磁盘
        FileSystem fslist[] = sigar.getFileSystemList();
        List<SysDisk>list=new ArrayList<>();
        for (int i = 0; i < fslist.length; i++) {
            FileSystem fs = fslist[i];
            SysDisk sysDisk=new SysDisk();
            //磁盘名称
            sysDisk.setDevName(fs.getDevName());

            FileSystemUsage usage = null;
            usage = sigar.getFileSystemUsage(fs.getDirName());
            switch (fs.getType()) {
                case 0: // TYPE_UNKNOWN ：未知
                    break;
                case 1: // TYPE_NONE
                    break;
                case 2: // TYPE_LOCAL_DISK : 本地硬盘
                    //磁盘大小
                    sysDisk.setDiskTotal(usage.getTotal() + "KB");
                    //磁盘剩余大小
                    sysDisk.setDiskFree(usage.getFree() + "KB");
                    break;
                case 3:// TYPE_NETWORK ：网络
                    break;
                case 4:// TYPE_RAM_DISK ：闪存
                    break;
                case 5:// TYPE_CDROM ：光驱
                    break;
                case 6:// TYPE_SWAP ：页面交换
                    break;
            }
            list.add(sysDisk);


        }

        JSONArray jsonarray = JSONArray.fromObject(list);
        String jsonstr = jsonarray.toString();

        sysMonitor.setDisk(jsonstr);

        sysMonitor.setCreateDate(new Date());

        sysMonitor.setCreateTime(new Date());

        sysMonitorRepository.save(sysMonitor);




    }

    @Override
    public List<SysMonitor> findDate(int sittingdate) {
        return sysMonitorRepository.findDate(sittingdate);
    }
}
