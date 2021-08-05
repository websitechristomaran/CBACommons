/*
 *  ==============================================================================
 *
 *  Copyright 2020 Persh Corporation
 *  All rights reserved.
 *
 *  This program may not be duplicated, disclosed or provided to any third parties
 *  without the prior written consent of Persh Corporation.
 *
 *  Disassembly or de-compilation of the software and/or reverse engineering of
 *  the object code are prohibited.
 *
 *  ==============================================================================
 */

package com.qc.cba.commons.loggers;

import com.qc.cba.commons.codes.ApplicationCodes;

import java.util.logging.Logger;

public class CommonLogger {

    private CommonLogger() {
    }

    private static String QC_LOG_PREFIX = "[CBA | QC Log] ";

    private static Logger getLoggerObject(Class<?> value) {
        return Logger.getLogger(value.getName());
    }

    public static void info(Class<?> classType, String message) {
        getLoggerObject(classType).info(CommonLogger.QC_LOG_PREFIX.concat(message));
    }

    public static void warning(Class<?> classType, String message) {
        getLoggerObject(classType).warning(CommonLogger.QC_LOG_PREFIX.concat(message));
    }

    public static void error(Class<?> classType, String message) {
        getLoggerObject(classType).severe(CommonLogger.QC_LOG_PREFIX.concat(message));
    }

    public static void error(Class<?> classType, ApplicationCodes appResponse) {
        getLoggerObject(classType).severe(appResponse.logMessage());
    }

}
