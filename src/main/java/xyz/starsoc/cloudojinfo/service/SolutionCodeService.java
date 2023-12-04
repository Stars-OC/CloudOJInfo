package xyz.starsoc.cloudojinfo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.starsoc.cloudojinfo.mapper.SolutionMapper;
import xyz.starsoc.cloudojinfo.pojo.CloudOJCode;
import xyz.starsoc.cloudojinfo.pojo.ContestOneBlood;
import xyz.starsoc.cloudojinfo.pojo.PageList;

import java.util.List;

@Service
@Slf4j
public class SolutionCodeService {

    @Autowired
    private SolutionMapper mapper;

    public List<CloudOJCode> getContestAllCode(String username, Integer contestId) {

        List<CloudOJCode> list = mapper.checkContest(username, contestId);

        return list;
    }

    public List<ContestOneBlood> getContestOneBlood( Integer contestId) {

        List<ContestOneBlood> list = mapper.checkOneBlood(contestId);

        return list;
    }

    public PageList<CloudOJCode> getProblemSubmitCode(String username, Integer problemId, Integer limit) {

        List<CloudOJCode> list = mapper.getUsernameOneCode(username, problemId, limit);

        return new PageList<>(list);
    }
}
