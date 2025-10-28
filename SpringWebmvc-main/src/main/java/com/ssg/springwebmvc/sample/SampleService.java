package com.ssg.springwebmvc.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor   //생성자 주입 방식
public class SampleService {

    @Qualifier("event")
    private final SampleDAO sampleDAO;

    @Override public String toString() {
        return "SampleService(sampleDAO=" + AopUtils.getTargetClass(sampleDAO).getName() +")";
    }
}
