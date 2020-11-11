package com.bluewave.systemmonitor;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.io.FileUtils;
import org.hyperic.jni.ArchNotSupportedException;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarLoader;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.*;
import java.net.URI;

/**
 * @Author: Guosh
 * @Date: 2019-08-23 13:04
 */

@Configuration
public class SigarConfig {

    //静态代码块
    static {
        try {
            initSigar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //初始化sigar的配置文件
    public static void initSigar() throws IOException, ArchNotSupportedException {

//        System.setProperty("java.library.path","");
//        System.out.println("启动成功！"+System.getProperty("java.library.path"));

        SigarLoader loader = new SigarLoader(Sigar.class);
        String lib = loader.getLibraryName();

        //ClassPathResource resource = new ClassPathResource("/sigar.so/"+lib);
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:/sigar.so/" + lib);
        InputStream is = resource.getInputStream();


        File tempDir = new File("sigarso");
        if (!tempDir.exists()){
            tempDir.mkdir();
        }

        BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(tempDir, lib), false));
        int lentgh = 0;
        while ((lentgh = is.read()) != -1){
            os.write(lentgh);
        }
        is.close();
        os.close();
        System.setProperty("java.library.path",tempDir.getCanonicalPath());
        System.out.println("启动成功！"+System.getProperty("java.library.path"));



    }
}
