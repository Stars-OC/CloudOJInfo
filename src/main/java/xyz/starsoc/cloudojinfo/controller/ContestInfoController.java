package xyz.starsoc.cloudojinfo.controller;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xyz.starsoc.cloudojinfo.pojo.Result;
import xyz.starsoc.cloudojinfo.service.ContestInfoService;

@Slf4j
@RestController
@Validated
@RequestMapping("/contest")
public class ContestInfoController {
    @Autowired
    private ContestInfoService contestInfoService;

    /**
     * 获取比赛信息
     * @param contestId 比赛ID
     * @return Result 比赛信息的Result对象
     */
    @GetMapping("/info/{contestId}")
    public Result getContestInfoById(@PathVariable("contestId") @NotNull int contestId) {
        return contestInfoService.getContestInfoById(contestId);
    }

    @GetMapping("/info/name/{contestName}")
    public Result getContestInfoByName(@PathVariable("contestName") @NotEmpty String contestName) {

        return contestInfoService.getContestInfoByName(contestName);

    }

}
