package com.green.greengram2.user;

import com.green.greengram2.ResVo;
import com.green.greengram2.user.model.UserSignupDto;
import com.green.greengram2.user.model.UserSignupProcDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int userSignIn(UserSignupProcDto pDto);
}
