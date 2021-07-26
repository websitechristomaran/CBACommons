package com.qc.cba.commons.misc;

import com.qc.cba.commons.codes.ApplicationCodes;
import com.qc.cba.commons.codes.HTTPCodes;
import com.qc.cba.commons.exceptions.WebExceptionType;
import com.qc.cba.commons.exceptions.WebServiceException;
import com.qc.cba.commons.loggers.CommonLogger;

public class Validator {

    private Validator() {
    }

    public static String ignoreNullByString(String any) {
        // This methods will have string argument and returns the same if not null else will return an empty string
        if (any == null) {
            CommonLogger.warning(Validator.class, "[ignoreNullByString()] Given input is null. Returning Empty string...");
            return "";
        }
        CommonLogger.info(Validator.class, "[ignoreNullByString()] Given input is [".concat(any).concat("] is not null. Returning the same string..."));
        return any;
    }

    public static void notNull(Object value) throws WebServiceException {
        if (value == null)
            throw new WebServiceException(ApplicationCodes.VALIDATION_NULL_FOUND, HTTPCodes.BAD_REQUEST, WebExceptionType.VALIDATION);
    }

    public static boolean isNull(Object value) {
        return value == null;
    }

    public static boolean isNotNull(Object value) {
        return value != null;
    }

}
