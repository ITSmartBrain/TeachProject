package logs;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.logging.LogManager;


public class TestLog {
//    static final Logger rootLogger = LogManager.getRootLogger();
//    static final Logger userLogger = LogManager.getLogger(TestLog.class);
    public static void main(String[] args) {

        Logger foobar = LoggerFactory.getLogger("logsFile");

        foobar.warn("This is logged from foobar");
        foobar.info("INFO");



        int val = new Random().nextInt(0x55555555)+0x10000000;
        String str = Integer.toHexString(val);
        System.out.println(str+" "+str.length());
        System.out.println(Integer.parseInt("1234567F", 16));
//        logs.TestLog testLog = new logs.TestLog();
//        userLogger.info("info 1");
//        userLogger.info("info 2");
//
//        rootLogger.info("Root Logger: "  + "info 3");
//
//        //debug
//        if (rootLogger.isDebugEnabled()) {
//            rootLogger.debug("RootLogger: In debug message");
//            userLogger.debug("UserLogger in debug");
//        }
//
//        try {
//
//            throw new NullPointerException("some ex");
//        } catch (NullPointerException ex) {
//            userLogger.error("error message: " + ex.getMessage());
//            userLogger.fatal("fatal error message: " + ex.getMessage());
//        }
    }
}
