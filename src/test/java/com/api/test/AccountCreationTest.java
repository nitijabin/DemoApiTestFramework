package com.api.test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.TestListener.class)
public class AccountCreationTest {

    @Test(description = "Verify if signup api is working...")
    public void createAccountTest() {

        String username = "Aariz" + Math.random() * 100;
        SignUpRequest signUpRequest = new SignUpRequest.Builder().userName(username)
                .firstName("Ariz").lastName("Fais").email(username + "@yahoo.com")
                .password("aariz123").mobileNumber("7777777776").build();

        AuthService authService = new AuthService();
        Response response = authService.signUp(signUpRequest);
        Assert.assertEquals(response.prettyPrint(), "User registered successfully!");

    }
}
