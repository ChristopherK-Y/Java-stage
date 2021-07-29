package com.kunyan.tingshu.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Story {
    private Integer sid;
    private Integer aid;
    private String name;
    private Date createdAt;
    private Integer count;
}
