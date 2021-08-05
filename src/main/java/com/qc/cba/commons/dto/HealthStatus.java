package com.qc.cba.commons.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.qc.cba.commons.misc.QcSwagger;

public class HealthStatus {

    private String status;
    private String productOwner;
    private String developerName;

    public HealthStatus(String uri) {
        this.status = "UP";
        this.productOwner = QcSwagger.COMPANY;
        this.developerName = "Maria Irudaya Regilan J";
    }

    @JsonProperty("Status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("ProductOwner")
    public String getProductOwner() {
        return productOwner;
    }

    @JsonProperty("DeveloperName")
    public String getDeveloperName() {
        return developerName;
    }
}
