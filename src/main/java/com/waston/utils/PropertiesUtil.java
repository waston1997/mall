package com.waston.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @Author wangtao
 * @Date 2018/1/19
 **/
public class PropertiesUtil {

    private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    private static Properties properties = new Properties();

    static {
        String fileName = "mall.properties";
        try {
            //统一编码为UTF-8
            properties.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName), "UTF-8"));
        } catch (Exception e) {
            logger.error("加载配置文件失败", e.getMessage());
        }
    }

    /**
     * 获取属性值, 会去掉前后多余的空格
     * @param key
     * @return
     */
    public static String getProperty(String key) {
        String value =  properties.getProperty(key.trim());
        if(StringUtils.isEmpty(value))
            return null;
        return value.trim();
    }

    /**
     * 获取属性值, 会去掉前后多余的空格, 如果没有此属性返回默认值
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getProperty(String key, String defaultValue) {
        String value =  properties.getProperty(key.trim());
        if(StringUtils.isEmpty(value))
            return defaultValue;
        return value;
    }

}
