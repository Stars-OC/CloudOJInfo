package xyz.starsoc.cloudojinfo.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.starsoc.cloudojinfo.mapper.SolutionMapper;
import xyz.starsoc.cloudojinfo.pojo.ContestAllCode;
import xyz.starsoc.cloudojinfo.pojo.ContestOneBlood;
import xyz.starsoc.cloudojinfo.pojo.Result;
import xyz.starsoc.cloudojinfo.service.SolutionCodeService;

import java.util.List;

@RestController
@Slf4j
public class SolutionCodeController {


    @Autowired
    private SolutionCodeService solutionCodeService;

    @GetMapping("/contest/code/allPrefer")
    public Result<List<ContestAllCode>> allPrefer(@RequestParam String username, String contestId){

        if (StringUtils.isEmpty(contestId) || StringUtils.isEmpty(username)){
            return Result.failure("参数错误");
        }

        List<ContestAllCode> list = solutionCodeService.getContestAllCode(username, contestId);

        return list.isEmpty()?Result.failure("获取失败"):Result.success("获取成功",list);
    }

    @GetMapping("/contest/code/allBlood")
    public Result<List<ContestOneBlood>> allBlood(@RequestParam String username, String contestId){

        if (StringUtils.isEmpty(contestId) || StringUtils.isEmpty(username)){
            return Result.failure("参数错误");
        }

        List<ContestOneBlood> list = solutionCodeService.getContestOneBlood(username, contestId);

        return list.isEmpty()?Result.failure("获取失败"):Result.success("获取成功",list);
    }

    @GetMapping("/user/code/prefer")
    public Result prefer(){
        return Result.success("测试成功");
    }
}
