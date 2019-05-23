package bookexchanger.api.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserTmp {

    public Integer getUserId() {
        try (InputStream inputStream = new FileInputStream(new File("./src/main/resources/data.properties"))) {

            Properties properties = new Properties();
            properties.load(inputStream);
            return Integer.valueOf(properties.getProperty("user.id", null));
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }

    public static void main(String[] args) {
        System.out.println(new UserTmp().getUserId());
    }
}

