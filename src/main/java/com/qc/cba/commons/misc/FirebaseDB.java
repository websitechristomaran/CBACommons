package com.qc.cba.commons.misc;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.qc.cba.commons.codes.ApplicationCodes;
import com.qc.cba.commons.codes.HTTPCodes;
import com.qc.cba.commons.dto.IDLookupDocument;
import com.qc.cba.commons.exceptions.WebExceptionType;
import com.qc.cba.commons.exceptions.WebServiceException;
import com.qc.cba.commons.loggers.CommonLogger;

import java.util.concurrent.ExecutionException;

public class FirebaseDB {

    private static FirebaseDB firebaseDB;
    private final String LOOKUP_DOCUMENT_NAME = "lookup";

    public static FirebaseDB connect() {
        if (Validator.isNull(FirebaseDB.firebaseDB))
            FirebaseDB.firebaseDB = new FirebaseDB();
        return FirebaseDB.firebaseDB;
    }

    public Integer getLatestIDFromLookupDocument(Firestore firestore, String collectionName) throws WebServiceException {
        CommonLogger.info(FirebaseDB.class, "Connecting to Firebase Firestore for retrieving Lookup document...");
        ApiFuture<DocumentSnapshot> future = firestore.collection(collectionName).document(this.LOOKUP_DOCUMENT_NAME).get();
        DocumentSnapshot document;

        try {
            document = future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new WebServiceException(ApplicationCodes.FIREBASE_DOCUMENT_EXCEPTION, HTTPCodes.INTERNAL_ERROR, WebExceptionType.DATABASE_ERROR);
        }

        if (Validator.isNotNull(document)) {
            if (document.exists() && document.getData() != null) {
                IDLookupDocument lookupDocument = new IDLookupDocument(document.getData());
                CommonLogger.info(FirebaseDB.class, "Lookup document received");
                if (Validator.isNotNull(lookupDocument.getIdValue())) {
                    CommonLogger.info(FirebaseDB.class, "Returning Latest ID value from Lookup document");
                    return lookupDocument.getIdValue();
                } else {
                    throw new WebServiceException(ApplicationCodes.DOCUMENT_LOOKUP_LATEST_ID_NOT_FOUND, HTTPCodes.INTERNAL_ERROR, WebExceptionType.INTERNAL_ERROR);
                }
            } else {
                throw new WebServiceException(ApplicationCodes.FIREBASE_DOCUMENT_NOT_RETRIEVED, HTTPCodes.INTERNAL_ERROR, WebExceptionType.INTERNAL_ERROR);
            }
        } else {
            throw new WebServiceException(ApplicationCodes.FIREBASE_DOCUMENT_NOT_EXIST, HTTPCodes.INTERNAL_ERROR, WebExceptionType.INTERNAL_ERROR);
        }
    }

    public void updateLatestIDToLookupDocument(Firestore firestore, String collectionName, String newIDValue) throws WebServiceException {
        CommonLogger.info(FirebaseDB.class, "Connecting to Firebase Firestore for updating Lookup document with new ID [".concat(newIDValue).concat("]..."));
        ApiFuture<?> future = firestore.collection(collectionName).document(this.LOOKUP_DOCUMENT_NAME).update(QcCommonConstants.LOOKUP_DOC_LATEST_ID, newIDValue);
        WriteResult writeResult;

        try {
            writeResult = (WriteResult) future.get();
            CommonLogger.info(FirebaseDB.class, "Lookup document successfully written to DB [".concat(QcUtils.objectToJsonString(writeResult)).concat("]"));
        } catch (InterruptedException | ExecutionException e) {
            throw new WebServiceException(ApplicationCodes.FIREBASE_DOCUMENT_EXCEPTION, HTTPCodes.INTERNAL_ERROR, WebExceptionType.DATABASE_ERROR);
        }
    }

}
