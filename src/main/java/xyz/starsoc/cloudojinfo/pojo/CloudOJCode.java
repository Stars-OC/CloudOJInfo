package xyz.starsoc.cloudojinfo.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CloudOJCode extends CloudOJUser {

    private Integer problemId;
    private String title;
    private Double score;
    private String code;
    private String result;
    private Long time;

}
