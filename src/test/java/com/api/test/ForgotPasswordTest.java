package com.api.test;

import com.api.base.AuthService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ForgotPasswordTest {

    @Test(description = "Verify forgot passwprd...")
    public void forgotPassword(){
        AuthService authService = new AuthService();
        Response response = authService.forgotPassword("sharma@gmail.com");
        System.out.println(response.prettyPrint());
    }
}
