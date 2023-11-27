package xyz.starsoc.cloudojinfo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xyz.starsoc.cloudojinfo.pojo.ContestAllCode;
import xyz.starsoc.cloudojinfo.pojo.Solution;

import java.util.List;

@Mapper
public interface SolutionMapper extends BaseMapper<Solution> {

    /**查询 contestId 比赛 中 username 所有题目最高分代码**/
    List<ContestAllCode> checkContest(String username, String contestId);
}
