package util;

import java.io.IOException;
import java.util.Properties;

public class Config {
    public static Properties properties=new Properties();

    /**
     * @param key Передаем ключ для чтения из конфиг файла
     * @return value Возвращаем значение поля
     */
    public static String read(String key) {
        //System.out.println("Считываем конфиг по ключу - "+key);

        if (properties.isEmpty()) {
            try {
                properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
        //        System.out.println(properties.getProperty(key));
                return properties.getProperty(key);

            } catch (IOException e) {
                System.out.println("ОШИБКА: Файл свойств отсуствует!");
            }
        }

        return properties.getProperty(key);
    }
}

