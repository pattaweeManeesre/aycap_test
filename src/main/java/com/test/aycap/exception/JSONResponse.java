package com.test.aycap.exception;

import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;

public class JSONResponse extends JSONObject {
    public JSONResponse() {
        Field field;
        try {
            field = this.getClass().getSuperclass().getDeclaredField("map");
            field.setAccessible(true);
            field.set(this, new LinkedHashMap<>());
            field.setAccessible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JSONObject fail() {
        this.put("code", "0001");
        this.put("description", "Unknown Error");
        return this;
    }

    public JSONObject fail(ErrorCode errorCode) {
        this.put("code", errorCode.getErrorCode());
        this.put("description", errorCode.getErrorMessage());
        return this;
    }
}
