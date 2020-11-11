package com.bluewave.systemmonitor.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: Guosh
 * @Date: 2019-08-23 09:34
 * 系统监控
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sys_monitor")
public class SysMonitor {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    /**
     * 操作系统
     */
    @Column(name = "operat_system")
    private String operatSystem;

    /**
     * 总内存
     */
    @Column(name = "total_memory")
    private Long totalMemory;

    /**
     * 使用内存
     */
    @Column(name = "used_memory")
    private Long usedMemory;


    /**
     * 剩余内存
     */
    @Column(name = "left_memory")
    private Long leftMemory;


    /**
     * 处理器个数
     */
    @Column(name = "process_num")
    private Integer processNum;


    /**
     * cpu占用率
     */
    @Column(name = "cpu_used")
    private String cpuUsed;


    /**
     * cpu空闲率
     */
    @Column(name = "cpu_freed")
    private String cpuFreed;


    /**
     * 磁盘
     */
    @Column(name = "disk")
    private String disk;

    /**
     * 统计日期
     */
    @Column(name = "create_date")
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createDate;


    /**
     * 统计时间
     */
    @Column(name = "create_time")
    @JsonFormat(timezone="GMT+8",pattern="HH:mm")
    @DateTimeFormat(pattern="HH:mm")
    private Date createTime;

}
