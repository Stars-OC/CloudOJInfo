package xyz.starsoc.cloudojinfo.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.starsoc.cloudojinfo.pojo.CloudOJCode;
import xyz.starsoc.cloudojinfo.pojo.ContestOneBlood;
import xyz.starsoc.cloudojinfo.pojo.Result;
import xyz.starsoc.cloudojinfo.service.SolutionCodeService;

import java.util.List;

@RestController
@Slf4j
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
    public Result<List<CloudOJCode>> allPrefer(@RequestParam String username, Integer contestId){

        // 检查参数是否为空
        if (contestId == null || StringUtils.isEmpty(username)){
            return Result.failure("参数错误");
        }

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
    public Result<List<ContestOneBlood>> allBlood(@RequestParam Integer contestId){

        if (contestId == null){
            return Result.failure("参数错误");
        }

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
    public Result<List<CloudOJCode>> submit(@RequestParam(defaultValue = "5") Integer limit,
                                            @RequestParam String username, Integer problemId){

        // 检查参数是否为空
        if (problemId == null || StringUtils.isEmpty(username)){
            return Result.failure("参数错误");
        }

        // 获取指定问题的提交代码列表
        List<CloudOJCode> list = solutionCodeService.getProblemSubmitCode(username, problemId, limit);

        // 检查获取结果是否为空，返回相应的结果对象
        return list.isEmpty()?Result.failure("获取失败"):Result.success("获取成功",list);
    }


    @GetMapping("/user/code/prefer")
    public Result prefer(){
        return Result.success("测试成功");
    }
}
