package com.api.test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.path.json.JsonPath;
import  io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAPITest {

    @Test(description = "Verify if login API is working...")
    public void loginTest(){
      /*  RestAssured.baseURI = "http://64.227.160.186:8080";
        RequestSpecification reqst = RestAssured.given()
                .header("Content-Type", "application/json")
                .body("{\"username\": \"uday1234\", \"password\": \"uday1234\"}");
                Response resp = reqst.post("/api/auth/login");
       */

        AuthService authService = new AuthService();
        LoginRequest loginRequest = new LoginRequest("uday123", "uday123");
        Response resp = authService.login(loginRequest);
        LoginResponse loginResponse = resp.as(LoginResponse.class);
        Assert.assertEquals(loginResponse.getId(), 305);
    }
}
