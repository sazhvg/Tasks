package com.ua.sazhyn.volodymyr.springtask.repository;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Set;

public class Data {

    private static Set<Data> data = new HashSet<>(); //список не унікальних даних

    public static void add(Data data){
        Data.data.add(data);
    }

    public static Set<Data> getData() {
        return data;
    }

    @JsonProperty("project")
    private String project;
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("compilationTime")
    private int compilationTime;
    @JsonProperty("result")
    public String result;

    public Data(String project, String timestamp, int compilationTime, String result) {
        this.project = project;
        this.timestamp = timestamp;
        this.compilationTime = compilationTime;
        this.result = result;
    }

    public String getProject() {
        return project;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public int getCompilationTime() {
        return compilationTime;
    }

    public String getResult() {
        return result;
    }
}
