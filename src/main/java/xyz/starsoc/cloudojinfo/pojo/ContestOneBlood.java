package xyz.starsoc.cloudojinfo.pojo;

import lombok.Data;

@Data
public class ContestOneBlood extends CloudOJUser{

    private Integer problemId;
    private String title;
    private Long time;

}
