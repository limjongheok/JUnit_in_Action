package com.example.junit.sampleTest;

public class SampleResponse implements Response {

    private static final String DEFAULT_NAME = " test";

    private String name;
    public SampleResponse(Request request) {
        this.name = request.getName();
    }

    public SampleResponse() {
        this.name = DEFAULT_NAME;
    }

    public String getName(){
        return name;
    }

    public boolean equals(Object object){
        boolean result = false;
        if(object instanceof SampleResponse){
            result = ((SampleResponse) object).getName().equals(getName());
        }

        return result;
    }

    public int hashCode(){
        return this.name.hashCode();
    }

}
