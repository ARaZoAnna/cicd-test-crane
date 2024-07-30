package com.est.cranejob.recruit.service;

import com.est.cranejob.recruit.domain.Recruit;
import com.est.cranejob.recruit.dto.RecruitInfo;
import com.est.cranejob.recruit.repository.RecruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchedulerService {

    RecruitService recruitService;
    RecruitRepository recruitRepository;

    @Autowired
    public SchedulerService(RecruitService recruitService, RecruitRepository recruitRepository) {
        this.recruitService = recruitService;
        this.recruitRepository = recruitRepository;
    }

    @Value("${SARAMIN.ApiKey}")
    String apiKey;
    @Value("${SARAMIN.Job_Mid_Cd}")
    String job_mid_cd; //job_mid_cd
    @Value("${SARAMIN.Count}")
    String count;

    //매일 밤11시 실행
    //@Scheduled(cron = "0 0 23 * * *")
    //5초마다 실행 test용
    @Scheduled(fixedRate = 10000)
    public void run(){

        System.out.println("hello");
    //api 채용 정보 가져오기
        List<RecruitInfo> info = recruitService.callApi(apiKey,job_mid_cd,count);
    //db에 저장하기
        for (RecruitInfo infoTemp : info) {
            Recruit recruit = infoTemp.toEntity();
            recruitRepository.save(recruit);
        }
    }
}