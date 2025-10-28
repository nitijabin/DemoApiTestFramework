package com.api.test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class GetProfileRequestTest {

    @Test(description = "Verify get profile...")
    public void getProfileInfo() {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("uday123", "uday123"));
        String token = response.jsonPath().getString("token");
        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        Response resp = userProfileManagementService.getProfile(token);
        //System.out.println("Get Profile: " + resp.prettyPrint());
        UserProfileResponse userProfileResponse = resp.as(UserProfileResponse.class);
        logger.info("The log for the : "+ userProfileResponse.toString());
        System.out.println(userProfileResponse.getFirstName());
    }
}
