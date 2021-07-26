package com.qc.cba.commons.codes;

import java.text.MessageFormat;

public enum ApplicationCodes {

    NO_BODY_FOUND(10001, "Null response body found"),
    VALIDATION_NULL_FOUND(10002, "Null object found in a non-null place"),
    INTERNAL_SERVER_ERROR(10003, "Some internal error occurred"),
    ERROR_JACKSON_CONVERSION(10004, "Some internal error occurred when parsing the argument with jackson methods"),
    DOCUMENT_LOOKUP_LATEST_ID_NOT_FOUND(10005, "Latest ID parameter missing the Lookup document"),
    FIREBASE_GOOGLE_CREDENTIALS_STREAM_ERROR(10006, "Error occurred during parsing Google Credentials strings"),
    FIREBASE_DOCUMENT_EXCEPTION(10007, "Interruption or Execution exception occurred while getting a document from ApiFuture"),
    FIREBASE_DOCUMENT_NOT_EXIST(10008, "Requested Firebase document not available in Firestore"),
    FIREBASE_DOCUMENT_NOT_RETRIEVED(10009, "Available Firestore document is not retrieved"),
    INVALID_DATE_FORMAT_PARSE_TIMESTAMP(10010, "Invalid String Date Format found when parsing to Timestamp"),
    INVALID_DATE_TIME_FORMAT_PARSE_TIMESTAMP(10011, "Invalid String DateTime Format found when parsing to Timestamp");

    private int appCode;
    private String appCodeDescription;

    ApplicationCodes(int appCode, String appCodeDescription) {
        this.appCode = appCode;
        this.appCodeDescription = appCodeDescription;
    }

    public int getAppCode() {
        return appCode;
    }

    public String getAppCodeDescription() {
        return appCodeDescription;
    }

    public String logMessage() {
        final String messageFormat = "{0} - {1}";
        return MessageFormat.format(messageFormat, this.getAppCode(), this.getAppCodeDescription());
    }
}
