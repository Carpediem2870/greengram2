package com.green.greengram2.user;

import com.green.greengram2.ResVo;
import com.green.greengram2.user.model.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int userSignUp(UserSignupProcDto pDto);
    UserSigninProcVo userSignin(String uid);
}
