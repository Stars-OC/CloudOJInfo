package xyz.starsoc.cloudojinfo.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.starsoc.cloudojinfo.pojo.CloudOJCode;
import xyz.starsoc.cloudojinfo.pojo.CloudOJListCode;
import xyz.starsoc.cloudojinfo.pojo.ContestOneBlood;
import xyz.starsoc.cloudojinfo.pojo.Result;
import xyz.starsoc.cloudojinfo.service.SolutionCodeService;

import java.util.List;

@RestController
@Slf4j
@Validated
public class SolutionCodeController {


    @Autowired
    private SolutionCodeService solutionCodeService;

    /**
     * 获取指定用户名在指定比赛中的所有最好代码
     *
     * @param username 指定的用户名
     * @param contestId 指定的比赛ID
     * @return 结果对象包含成功与否和代码列表
     */
    @GetMapping("/contest/code/allPrefer")
    public Result<List<CloudOJCode>> allPrefer(@RequestParam @NotEmpty(message = "用户名不能为空") String username,
                                               @NotNull(message = "contestId不能为空") Integer contestId){

        // 调用服务层获取代码列表
        List<CloudOJCode> list = solutionCodeService.getContestAllCode(username, contestId);

        // 判断代码列表是否为空
        return list.isEmpty()?Result.failure("获取失败"):Result.success("获取成功",list);
    }


    /**
     * 获取指定竞赛所有获取一血的详细数据
     *
     * @param contestId 指定的比赛ID
     * @return 结果和代码列表
     */
    @GetMapping("/contest/code/allBlood")
    public Result<List<ContestOneBlood>> allBlood(@RequestParam @NotNull(message = "contestId不能为空") Integer contestId){

        List<ContestOneBlood> list = solutionCodeService.getContestOneBlood(contestId);

        return list.isEmpty()?Result.failure("获取失败"):Result.success("获取成功",list);
    }


    /**
     * 获取用户提交的代码列表 (降序排列)
     *
     * @param username 用户名
     * @param problemId 问题ID
     * @param limit 限制获取的数量
     *
     * @return 结果对象，包含成功或失败的状态和可能的错误信息。如果结果为成功，还包含提交代码列表。
     */
    @GetMapping("/problem/code/getSubmit")
    public Result<CloudOJListCode> submit(@RequestParam(defaultValue = "5") Integer limit,
                                          @NotEmpty(message = "用户名不能为空") String username,
                                          @NotNull(message = "problemId不能为空") Integer problemId){

        // 获取指定问题的提交代码列表
        CloudOJListCode list = solutionCodeService.getProblemSubmitCode(username, problemId, limit);

        // 检查获取结果是否为空，返回相应的结果对象
        return list.getCount() == 0?Result.failure("获取失败"):Result.success("获取成功",list);
    }


    @GetMapping("/user/code/prefer")
    public Result prefer(){
        return Result.success("测试成功");
    }
}
