package cn.felix.multipledatsource.util;

import java.io.IOException;
import java.util.Properties;

/**
 * 描述：
 *
 * @author potter
 * @create 2018-06-13 17:20
 */
public class PropertiesTools {

    private static Properties properties = new Properties();

    private static final String TASK_FILE = "task.properties";

    static {
        try {
            properties.load(PropertiesTools.class.getClassLoader().getResourceAsStream(TASK_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        return (String) properties.get(key);
    }

    public static void main(String[] args) {
        System.out.println(PropertiesTools.getValue("task"));
    }
}
