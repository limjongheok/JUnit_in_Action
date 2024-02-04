package com.example.junit.sampleTest;

public class SampleHandler implements RequestHandler {
    @Override
    public Response process(Request request) throws Exception {
        return new SampleResponse(request);
    }
}
