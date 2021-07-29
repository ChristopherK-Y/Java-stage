package com.kunyan.tingshu.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class Album {
    private Integer aid;
    private Integer uid;
    private String name;
    private String cover;
    private String header;
    private String brief;
    private Date createdAt;
    private Integer count;
    public List<Story> storyList;
}
