package xyz.starsoc.cloudojinfo.pojo;

import lombok.Data;

@Data
public class CloudOJCode extends CloudOJUser {

    private Integer problemId;
    private String title;
    private Double score;
    private String code;
    private String result;
    private Long time;

}
