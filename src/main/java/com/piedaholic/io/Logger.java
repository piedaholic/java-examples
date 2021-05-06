package com.piedaholic.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Logger {
    public static String dbgPath;
    public static char dbgEnabled = 'N';
    public static char tsEnabled = 'N';
    public static String tsLocale = "en";
    public static String tsFormat = "dd-MM-yyyy hh:mm:ss ZZZZ";
    public static String tsEnclosingChar = "[]";
    public static String loggerLevel = "INFO";

    public Logger(String dbgPath, char dbgEnabled) {
        Logger.dbgEnabled = dbgEnabled;
        Logger.dbgPath = dbgPath;
    }

    public Logger(String dbgPath, char dbgEnabled, char tsEnabled) {
        Logger.dbgEnabled = dbgEnabled;
        Logger.dbgPath = dbgPath;
        Logger.tsEnabled = tsEnabled;
    }

    public Logger(String loggerPropertiesFile) {
        File file = new File(loggerPropertiesFile);
        if (file.exists()) {
            try (FileReader fr = new FileReader(file)) {
                Properties properties = new Properties();
                properties.load(fr);
                Logger.dbgEnabled = properties.getProperty("logger.enabled").charAt(0);
                Logger.dbgPath = properties.getProperty("logger.path");
                File loggerFile = new File(Logger.dbgPath);
                if (!loggerFile.exists() || !loggerFile.isDirectory()) {
                    Logger.dbgEnabled = 'N';
                    return;
                }

            } catch (IOException e) {

            }
        }
    }

    public static void dbg() {

    }

}
