package common;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import validate.TouchFlightSearchValidate;

public class Log {
    private static Logger logger = Logger.getLogger(TouchFlightSearchValidate.class);

    public static Logger getLogger() {
       PropertyConfigurator.configure(".\\src\\properties\\log4j.properties");
        // 记录info级别的信息
        return logger;
    }

}

