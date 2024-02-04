package com.example.junit.sampleTest;

public class SampleExceptionHandler implements RequestHandler {
    @Override
    public Response process(Request request) throws Exception {
        return new SampleResponse(request);
    }
}
