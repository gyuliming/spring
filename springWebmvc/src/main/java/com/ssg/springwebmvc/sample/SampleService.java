package com.ssg.springwebmvc.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
//@Component // root-context.xml에 <bean></bean>에 넣은 것과 같음
@RequiredArgsConstructor // 생성자 주입 방식
public class SampleService {

//    @Autowired
    @Qualifier("event") // 인젝션하고 싶은 거 입력
    private final SampleDAO sampleDAO; // 스프링 컨테이너 안에서 생성한 하나의 객체 사용 ->  final

    @Override
    public String toString() {
        return "SampleService(SampleDAO=" + AopUtils.getTargetClass(sampleDAO).getName() + ")";
    }

    //    @RequiredArgsConstructor 의미
//    SampleService(SampleDAO sampleDAO) {
//        this.sampleDAO = sampleDAO;
//    }
}
