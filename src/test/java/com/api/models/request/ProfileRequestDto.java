package com.api.models.request;

import utils.SerializationUtils;

public class ProfileRequestDto {
    public String profileRequestDto(){
        ProfileRequest profileRequest =new ProfileRequest();
        profileRequest.setEmail("dontNo@yahoo.com");
        profileRequest.setFirstName("Sharma");
        profileRequest.setLastName("Disha");
        profileRequest.setMobileNumber("7777777778");
        return new SerializationUtils().serializeObjectToString(profileRequest);
    }
}
