package com.green.greengram2.user;

import com.green.greengram2.ResVo;
import com.green.greengram2.user.model.UserSigninDto;
import com.green.greengram2.user.model.UserSigninVo;
import com.green.greengram2.user.model.UserSignupDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j // Spring framework log 4 j   인터페이스를 상속받은 친구
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;

    @PostMapping("/signup")
    public ResVo postUserSignup (@RequestBody UserSignupDto dto){
        log.info("dto: {}", dto); // {} 자리에 타입지정안해도되고 안에 값이 들어감. 위에 @Slf4j 어노테이션활용
        ResVo rv = service.userSignIn(dto);
        return rv; //ResVo객체에 insert한 레코드 pk값을 담아서 응답
    }

    @PostMapping("/signin")
    public UserSigninVo login (@RequestBody UserSigninDto dto){
        log.info("dto: {}", dto);
        return service.userSignin(dto);
    }
}
