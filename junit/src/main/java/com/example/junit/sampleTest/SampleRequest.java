package com.example.junit.sampleTest;

public class SampleRequest implements Request {

    private String name;
    private static final String DEFAULT_NAME = "Test";

    public SampleRequest(String name) {
        this.name = name;

    }
    public SampleRequest() {
        this(DEFAULT_NAME);
    }


    @Override
    public String getName() {
        return this.name;
    }
}
