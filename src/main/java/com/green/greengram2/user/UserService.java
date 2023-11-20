package com.green.greengram2.user;

import com.green.greengram2.ResVo;
import com.green.greengram2.user.model.UserSignupDto;
import com.green.greengram2.user.model.UserSignupProcDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
        int affectedRows = mapper.userSignIn(pDto);
        if (affectedRows == 0) {
            return new ResVo(0);
        }
        return new ResVo(pDto.getIuser());
    }
}