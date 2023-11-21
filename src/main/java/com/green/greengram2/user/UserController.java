package com.green.greengram2.user;

import com.green.greengram2.ResVo;
import com.green.greengram2.user.model.UserSigninDto;
import com.green.greengram2.user.model.UserSigninVo;
import com.green.greengram2.user.model.UserSignupDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name="유저 API", description = "인증 관련")

public class UserController {
    private final UserService service;

    @Operation(summary = "회원가입", description = "회원가입 처리")
    @PostMapping("/signup")
    public ResVo postUserSignup (@RequestBody UserSignupDto dto){
        log.info("dto: {}", dto); // {} 자리에 타입지정안해도되고 안에 값이 들어감. 위에 @Slf4j 어노테이션활용
        ResVo rv = service.userSignIn(dto);
        return rv; //ResVo객체에 insert한 레코드 pk값을 담아서 응답
    }




    @Operation(summary = "인증", description = "아이디/비번을 활용한 인증처리")
    @Parameters (value = {
            @Parameter(name = "uid", description = "아이디"),
            @Parameter(name = "upw", description = "비밀번호")
    })
    @PostMapping("/signin")
        public UserSigninVo login (@RequestBody UserSigninDto dto){
            log.info("dto: {}", dto);
        return service.login(dto);
    }
}
