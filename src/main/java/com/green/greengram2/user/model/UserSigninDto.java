package com.green.greengram2.user.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
// 요청
@Getter
@Setter
@ToString
public class UserSigninDto {
    private String uid;
    private String upw;
}
