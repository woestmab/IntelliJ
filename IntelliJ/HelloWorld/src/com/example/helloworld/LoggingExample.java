package com.example.helloworld;

import org.apache.log4j.*;

/**
 * Created by Bdub on 1/28/16.
 */

public class LoggingExample {

    private final Logger log = Logger.getLogger(this.getClass());

    public void loggingExample() {
        log.setLevel(Level.TRACE);

        log.trace("Trace Message!");
        log.debug("Debug Message!");
        log.info("Info Message!");
        log.warn("Warn Message!");
        log.error("Error Message!");
        log.fatal("Fatal Message!");
    }
}