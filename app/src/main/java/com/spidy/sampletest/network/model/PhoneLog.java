package com.spidy.sampletest.network.model;

import com.google.gson.annotations.SerializedName;

public class PhoneLog
{
    @SerializedName("status")
    private String status;

    public PhoneLog(String status)
    {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
