package com.green.greengram2.user;

import com.green.greengram2.ResVo;
import com.green.greengram2.user.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;


/*    public ResVo userSignIn(UserSignupDto dto) {
        mapper.userSignIn(dto);
        ResVo vo = new ResVo();
        vo.setResult(dto.getIuser());
        return vo;
    }*/

    public ResVo userSignIn(UserSignupDto dto){
        String hashedPw = BCrypt.hashpw(dto.getUpw(), BCrypt.gensalt()); // 비밀번호 암호화
        log.info ("hashedPw: {}", hashedPw);
        UserSignupProcDto pDto = UserSignupProcDto.builder()
                .uid(dto.getUid())
                .upw(hashedPw)
                .nm(dto.getNm())
                .pic(dto.getPic())
                .build();
        int affectedRows = mapper.userSignUp(pDto);
        if (affectedRows == 0) {
            return new ResVo(0);
        }
        return new ResVo(pDto.getIuser());
    }

    public UserSigninVo login(UserSigninDto dto) {
        UserSigninProcVo procVo = mapper.userSignin(dto.getUid());
        UserSigninVo vo = new UserSigninVo();

        if (procVo == null) {
            vo.setResult(2);
            return vo;
        } else if (!BCrypt.checkpw(dto.getUpw(), procVo.getUpw())){

            vo.setResult(3);
            return vo;
        }else {
            vo.setResult(1);
            vo.setIuser(procVo.getIuser());
            vo.setNm(procVo.getNm());
            vo.setPic(procVo.getPic());
            return vo;
        }
    }


    //현수가 한거는 UserSigninVo에 전역변수에 upw 주석해제, 유저인터페이스에서 리턴타입이름 변경
/*    public UserSigninVo userSignin(UserSigninDto dto) {
        UserSigninVo vo = mapper.userSignin(dto.getUid());
        if (vo==null){
            vo = new UserSigninVo();
            vo.setResult(2);
            return vo;
        } // 아이디 없을 때
        boolean comparedPw= BCrypt.checkpw(dto.getUpw(), vo.getUpw());
        if (comparedPw) {
            vo.setResult(1);
        } else {
            vo= new UserSigninVo();
            vo.setResult(3);
        }
        // dto.getUpw() 입력한 비번, savedPw 암호화된 비번
        return vo;
    }*/



    /* 박스갈이 이때 UserSigninVo에 있는 Upw 변수 삭제하고
    UserMapper인터페이스에 있는 UserSigninVo타입을 UserSigninProcVo로 변경 */


}