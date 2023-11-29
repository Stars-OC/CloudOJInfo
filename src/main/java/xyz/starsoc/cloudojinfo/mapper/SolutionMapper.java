package xyz.starsoc.cloudojinfo.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.starsoc.cloudojinfo.pojo.CloudOJCode;
import xyz.starsoc.cloudojinfo.pojo.ContestOneBlood;

import java.util.List;

@Mapper
public interface SolutionMapper {

    /**
     * 查询 contestId 比赛中 username 所有题目最高分代码
     *
     * @param username 用户名称
     * @param contestId 比赛ID
     *
     * @return List<CloudOJCode>
     */
    List<CloudOJCode> checkContest(String username, Integer contestId);

    /**
     * 查询 contestId 比赛中 所有题目最先AC的人(一血)
     *
     * @param contestId 比赛ID
     *
     * @return List<ContestOneBlood>
     */
    List<ContestOneBlood> checkOneBlood(Integer contestId);

    /**
     * 查询 username 题目 problemId 的所有提交代码
     *
     * @param username 用户名称
     * @param problemId 题目ID
     * @param limit 限制条数
     *
     * @return List<CloudOJCode>
     */
    List<CloudOJCode> getUsernameOneCode(String username, Integer problemId,Integer limit);
}
