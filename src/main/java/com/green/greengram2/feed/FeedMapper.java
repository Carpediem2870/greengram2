package com.green.greengram2.feed;


import com.green.greengram2.feed.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMapper {

    int insFeed(FeedInsProcDto dto);
    int insFeedPic(FeedPicsInsProcDto dto);
    List<FeedSelVo> selFeedAll(FeedSelDto dto);
}
