package io.github.plizzzhealme.service;

import io.github.plizzzhealme.entity.Data;

public class Service {
    private static Data data = new Data();

    public static void addRecord(String record) {
        data.getData().add(record);
    }

    public static String readData() {
        return data.getData().toString();
    }

    public static void removeData(String record) {
        data.getData().remove(record);
    }
}
