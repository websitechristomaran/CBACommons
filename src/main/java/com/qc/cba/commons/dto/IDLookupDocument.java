package com.qc.cba.commons.dto;

import com.qc.cba.commons.misc.QcCommonConstants;

import java.util.Map;

public class IDLookupDocument {

    private Integer idValue;

    public IDLookupDocument(Map<String, Object> databaseValue) {
        this.idValue = ((Long) databaseValue.getOrDefault(QcCommonConstants.LOOKUP_DOC_LATEST_ID, null)).intValue();
    }

    public Integer getIdValue() {
        return idValue;
    }
}
