package xyz.starsoc.cloudojinfo.pojo;

import lombok.Data;

@Data
public class Solution {
    private Integer solutionId;
    private Integer problemId;
    private String title;
    private Integer uid;
    private Integer passed;
    private Integer total;
    private Double passRate;
    private Double score;
    private Long time;
    private Long memory;
    private Integer language;
    private Integer state;
    private Integer result;
}
