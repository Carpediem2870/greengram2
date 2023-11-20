package com.green.greengram2.user.model;

import lombok.Data;
// 응답
@Data

public class UserSigninVo {
    private int result; // 1: 성공, 2:아이디 없음, 3: 비밀번호 틀림
    private int iuser;
//    private String upw;
    private String nm;
    private String pic;

}
