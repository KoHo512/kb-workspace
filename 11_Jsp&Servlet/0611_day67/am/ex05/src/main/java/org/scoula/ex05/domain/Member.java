package org.scoula.ex05.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private String name;
    private String userid;

    public String getName() {
        return name;
    }

    public String getUserid() {
        return userid;
    }

    public int getAge() {
        return 10;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
