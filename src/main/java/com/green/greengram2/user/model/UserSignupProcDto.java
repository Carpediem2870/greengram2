package com.green.greengram2.user.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserSignupProcDto {
    private int iuser;
    private int result;
    private String uid;
    private String upw;
    private String nm;
    private String pic;
}
