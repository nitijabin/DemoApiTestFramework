package com.api.test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountCreationTest {

    @Test(description = "Verify if signup api is working...")
    public void createAccountTest(){

       SignUpRequest signUpRequest = new SignUpRequest.Builder().userName("Aariz123")
               .firstName("Ariz").lastName("Fais").email("Ariz123@yahoo.com")
               .password("aariz123").mobileNumber("7777777776").build();

        AuthService authService = new AuthService();
        Response response = authService.signUp(signUpRequest);
        Assert.assertEquals(response.jsonPath().getString("firstName"),"Ariz");
        System.out.println(response.prettyPrint());

    }
}
