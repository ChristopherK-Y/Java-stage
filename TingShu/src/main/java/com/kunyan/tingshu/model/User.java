package com.kunyan.tingshu.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private Integer uid;
    private String username;
    private String nickname;
    private String password;
}
