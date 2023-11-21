package com.green.greengram2.feed.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Data
public class FeedInsDto {

    private int iuser;
    private String contents;
    private String location;
    private List<String> pics;

}
