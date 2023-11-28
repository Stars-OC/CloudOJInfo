package xyz.starsoc.cloudojinfo.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class ContestAllCode extends CloudOJUser{

    private String title;
    private double score;
    private String code;
    private long time;

}
