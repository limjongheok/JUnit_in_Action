package com.example.junit.sampleTest;

public interface Request {
    String getName();
}

interface Response{

}

interface RequestHandler{
    Response process(Request request) throws Exception;
}

interface Controller {
    Response processRequest(Request request);
    void addHandler(Request request,RequestHandler requestHandler);
}