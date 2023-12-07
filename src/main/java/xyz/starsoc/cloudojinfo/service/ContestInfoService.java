package xyz.starsoc.cloudojinfo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.starsoc.cloudojinfo.mapper.ContestMapper;
import xyz.starsoc.cloudojinfo.pojo.Contest;
import xyz.starsoc.cloudojinfo.pojo.PageList;
import xyz.starsoc.cloudojinfo.pojo.Result;

import java.util.List;

@Service
public class ContestInfoService {

    @Autowired
    private ContestMapper contestMapper;

    /**
     * 通过contestId获取比赛信息
     *
     * @param contestId 比赛ID
     * @return Result对象，包含比赛信息和结果状态
     */
    public Result<Contest> getContestInfoById(int contestId) {
        // 根据比赛ID从contestMapper中查询比赛信息
        Contest contest = contestMapper.selectById(contestId);
        // 如果查询到比赛信息，则返回获取成功的结果，并带上比赛信息
        if (contest != null) {
            return Result.success("获取成功", contest);
        }
        // 如果查询不到比赛信息，则返回获取失败的结果
        return Result.failure("获取失败，该比赛不存在");
    }

    /**
     * 根据比赛名称获取比赛信息
     *
     * @param contestName 比赛名称
     * @return 结果及比赛页面列表
     */
    public Result<PageList<Contest>> getContestInfoByName(String contestName) {

        // 创建查询条件，根据比赛名称模糊匹配
        QueryWrapper<Contest> wrapper = new QueryWrapper<>();
        wrapper.like("contest_name", contestName);

        // 查询比赛列表
        List<Contest> contests = contestMapper.selectList(wrapper);

        // 若比赛列表为空，则返回获取失败
        if (contests.size() == 0) {
            return Result.failure("获取失败，该比赛不存在");
        }

        // 将比赛列表装入比赛页面列表对象
        PageList<Contest> contestPageList = new PageList<>(contests);

        // 返回获取成功及比赛页面列表
        return Result.success("获取成功", contestPageList);
    }

}
