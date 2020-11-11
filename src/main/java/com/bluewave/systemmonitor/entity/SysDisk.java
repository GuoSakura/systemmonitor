package com.bluewave.systemmonitor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @Author: Guosh
 * @Date: 2019-08-23 17:24
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SysDisk {

    //盘符名称
    private String DevName;

    //磁盘总大小
    private String DiskTotal;
    //磁盘剩余大小
    private String DiskFree;

}
