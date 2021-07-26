package com.qc.cba.commons.misc;

public class QcCommonConstants {

    public static final String LOOKUP_DOC_LATEST_ID = "id";

    public static final String DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm:ss";
    public static final String INPUT_DATE_FORMAT_1 = "[0-3][0-9][0-1][0-9][1-9][0-9]{3}";
    public static final String INPUT_DATE_FORMAT_2 = "[0-3][0-9]/[0-1][0-9]/[1-9][0-9]{3}";
    public static final String INPUT_TIME_FORMAT = "T00:00:00";
    public static final String INPUT_DATE_TIME_FORMAT_1 = QcCommonConstants.INPUT_DATE_FORMAT_1.concat(" [0-2][0-9][0-5][0-9][0-5][0-9]");
    public static final String INPUT_DATE_TIME_FORMAT_2 = QcCommonConstants.INPUT_DATE_FORMAT_2.concat(" [0-2][0-9]:[0-5][0-9]:[0-5][0-9]");

}
