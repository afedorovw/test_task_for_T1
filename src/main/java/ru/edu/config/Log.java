package ru.edu.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Log {

    Logger controllerLog = LoggerFactory.getLogger("BaseController Log");
    Logger startLog = LoggerFactory.getLogger("Start Log");
}
