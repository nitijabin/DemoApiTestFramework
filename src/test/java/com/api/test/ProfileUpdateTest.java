package com.api.test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.request.ProfileRequestDto;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ProfileUpdateTest {

    @Test(description = "Verify update user profile...")
    public void profileUpdateTest(){
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("uday123", "uday123"));
        String token = response.jsonPath().getString("token");

     /*   ProfileRequest profileRequest = new ProfileRequest.Builder().firstName("Uday")
                .lastName("Sharma").email("dontNo@yahoo.com").mobileNumber("7777777778").build();

      */
        ProfileRequestDto profileRequestDto = new ProfileRequestDto();

        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        Response resp = userProfileManagementService.updateProfile(token,  profileRequestDto.profileRequestDto());
        UserProfileResponse userProfileResponse = resp.as(UserProfileResponse.class);
        System.out.println(resp.prettyPrint());
        System.out.println(userProfileResponse.getFirstName());

    }
}
