package com.green.greengram2.feed.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class  FeedInsProcDto {

    private int ifeed;
    private int iuser;
    private String contents;
    private String location;

    public FeedInsProcDto(FeedInsDto dto){
        iuser = dto.getIuser();
        contents = dto.getContents();
        location = dto.getLocation();
    }
}
