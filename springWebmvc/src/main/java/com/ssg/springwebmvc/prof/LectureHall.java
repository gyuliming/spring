package com.ssg.springwebmvc.prof;

import lombok.RequiredArgsConstructor;
import org.springframework.aop.support.AopUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LectureHall {

    private final Professor professor;

    @Override
    public String toString() {
        return "LectureHall(Professor=" + AopUtils.getTargetClass(professor).getName() + ")";
    }
}
