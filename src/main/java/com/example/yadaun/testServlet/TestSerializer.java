package com.example.yadaun.testServlet;

import com.example.yadaun.entity.Test;
import com.google.gson.Gson;

public class TestSerializer {
    private static final Gson gson = new Gson();

    public static String serializeTest(Test test) {
        return gson.toJson(test);
    }

    public static Test deserializeTest(String serializedTest) {
        return gson.fromJson(serializedTest, Test.class);
    }
}