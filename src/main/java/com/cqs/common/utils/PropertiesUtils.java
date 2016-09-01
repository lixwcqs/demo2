package com.cqs.common.utils;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * 读取配置文件【目前只测了.properties配置文件】的工具类
 * Created by li on 2015/9/13.
 */
public class PropertiesUtils {

    private  static PropertiesConfiguration propertiesConfiguration;

    static {
        try {
            //初始化实例
            propertiesConfiguration = new PropertiesConfiguration("config.properties");
        } catch (ConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 读取config.properties的值
     * @param key：配置文件左侧的值
     * @return 配置文件右侧的值
     * 例子：projectPath=F:/ideal/demo2
     */
    public static String getProrperty(String key){
        return propertiesConfiguration.getString(key);
    }

}
