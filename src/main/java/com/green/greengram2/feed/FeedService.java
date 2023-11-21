package com.green.greengram2.feed;

import com.green.greengram2.ResVo;
import com.green.greengram2.feed.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class FeedService {

    private final FeedMapper maepper;
    private final FeedPicsMapper picsMapper;

    public ResVo insFeed(FeedInsDto dto){
        FeedInsProcDto procDto = new FeedInsProcDto(dto);
        int result = maepper.insFeed(procDto); // 박스갈이해서 iuser, contents, location을 procDto에 저장

        if (result == 0){
            ResVo vo = new ResVo(0);
            return vo;
        }


        FeedPicsInsProcDto picsDto = new FeedPicsInsProcDto(procDto.getIfeed(), dto.getPics());
        maepper.insFeedPic(picsDto);


        return new ResVo(procDto.getIfeed());
    }

    // N+1 허용
    public List<FeedSelVo> getFeedAll(FeedSelDto dto) {
        List<FeedSelVo> list = maepper.selFeedAll(dto);

        for (FeedSelVo vo  : list) {
            List<String> pics = picsMapper.selFeedPicsAll(vo.getIfeed());
            vo.setPics(pics);
            // vo.setPics(picsMapper.selFeedPicsAll(vo.getIfeed())); // 위의 두줄과 같은내용
        }
        return list;
    }

}
