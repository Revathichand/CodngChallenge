package com.hexaware.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//Utility class to load DB connection properties from a `.properties` file
public class DBPropertyUtil {

    //Loads the database connection properties from the given file path.
    public static Properties loadProperties(String fileName) throws IOException {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(fileName)) {
            props.load(fis);
        }
        return props;
    }
}
