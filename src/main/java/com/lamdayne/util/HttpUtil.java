package com.lamdayne.util;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;

public class HttpUtil {

    private String value;

    public HttpUtil(String value) {
        this.value = value;
    }

    public static HttpUtil of(BufferedReader reader) {
        StringBuilder sb = new StringBuilder();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
        return new HttpUtil(sb.toString());
    }

    public <T> T toModel(Class<T> tClass) {
        Gson gson = new Gson();
        return gson.fromJson(this.value, tClass);
    }
}
