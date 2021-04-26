package com.spidy.sampletest.network.model;

public class ValidKey
{
    String key,message;
    public ValidKey(String key,String message)
    {
        this.key = key;
        this.message = message;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
