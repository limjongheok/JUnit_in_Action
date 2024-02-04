package com.example.junit.sampleTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestDefaultController {
    private DefaultController controller;

    private Request request;
    private RequestHandler handler;
    @Before
    public void instantiate() throws Exception{
        controller = new DefaultController();
        request = new SampleRequest();
        handler = new SampleHandler();
        controller.addHandler(request,handler); // 중복 코드 제거
    }

    @Test
    public void testMethod(){
        throw new RuntimeException("implement me");
    }

    @Test
    public void testAddHandler(){
        //Request request = new SampleRequest();
        //RequestHandler handler = new SampleHandler();
        //controller.addHandler(request,handler);
        RequestHandler handler2 = controller.getHandler(request);
        Assert.assertSame(handler2,handler);
    }

    @Test
    public void testProcessRequest(){
        //Request request = new SampleRequest();
        //RequestHandler handler = new SampleHandler();
        //controller.addHandler(request,handler);
        Response response = controller.processRequest(request);
        Assert.assertNotNull("Must not return a null reponse",response);
            Assert.assertEquals("Response should be of type SampleResponse",response.getClass(),SampleResponse.class);

    }

    @Test
    public void testProcessRequest2(){
        Response response = controller.processRequest(request);
        Assert.assertNotNull("Must not return a null reponse",response);
        Assert.assertEquals(new SampleResponse(), response);
    }

    @Test
    public void testProcessRequestAnswersErrorResponse(){
        SampleRequest sampleRequest = new SampleRequest("testError");
        SampleExceptionHandler handler = new SampleExceptionHandler();
        controller.addHandler(sampleRequest,handler);
        Response response = controller.processRequest(sampleRequest);
        Assert.assertNotNull("Must not return a null reponse",response);
        Assert.assertEquals(ErrorResponse.class, response.getClass());
    }

    @Test(expected = RuntimeException.class)
    public void testGetHandlerNotDefined(){
        SampleRequest request = new SampleRequest("testDefined");

        controller.getHandler(request); // runtime 발생

    }


    // 예외 테스트
    @Test(expected = RuntimeException.class)
    public void testAddRequestDuplicateName(){
        SampleRequest request = new SampleRequest();
        SampleHandler handler = new SampleHandler();


        controller.addHandler(request,handler);
    }

    // timeout 테스트
    @Test(timeout = 130)
    @Ignore(value = "Ignore for now until we decide a decent time-limit")
    public void testProccessMultipleRequestsTimeout(){
        Request request;
        Response response = new SampleResponse();
        RequestHandler handler = new SampleHandler();
        for(int i=0; i<9999; i++){
            request = new SampleRequest(String.valueOf(i));
            controller.addHandler(request,handler);
            response = controller.processRequest(request);
            Assert.assertNotNull("Must not return a null reponse",response);
            Assert.assertEquals(SampleResponse.class, response.getClass());

        }
    }


}

// 틀린예시

/**
 * 하나 테스트 메서드 안에서 두개 이상 테스트 수행
 * public class TestDefaultController{
 *      @Test
 *      public void testAddAndProcess(){
 *          Request request = new SampleRequest();
 *          RequestHandler handler = new SampleHandler();
 *          controller.addHandler(request,handler);
 *          RequestHandler handler2 = controller.getHandler(request);
 *          assertEquals(handler2, handler);
 *
 *          Response response = controller.processRequest(request);
 *          assertNotNull("Must not return a null response", response);
 *          assertEquals(SampleReponse.class,repsponse.getClass);
 *
 *
 *      }
 * }
 */