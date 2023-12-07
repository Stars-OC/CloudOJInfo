package xyz.starsoc.cloudojinfo.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.List;

@Data
@TableName("contest")

public class Contest {

    @TableId
    private Integer contestId;
    private String contestName;
    private String inviteKey;
    private Long startAt;
    private Long endAt;
    private Integer languages;
    private Long createAt;

}
