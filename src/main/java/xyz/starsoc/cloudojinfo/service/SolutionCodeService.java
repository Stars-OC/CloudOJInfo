package xyz.starsoc.cloudojinfo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.starsoc.cloudojinfo.mapper.SolutionMapper;
import xyz.starsoc.cloudojinfo.pojo.ContestAllCode;

import java.util.List;

@Service
@Slf4j
public class SolutionCodeService {

    @Autowired
    private SolutionMapper mapper;

    public List<ContestAllCode> getContestAllCode(String username, String contestId) {

        List<ContestAllCode> list = mapper.checkContest(username, contestId);

        return list;
    }
}
