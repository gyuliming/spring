package com.ssg.springwebmvc.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Restaurant {

    @Autowired
    private final Chef chef;

    @Override
    public String toString() {
        return "Restaurant(Chef=" + AopUtils.getTargetClass(chef).getName() + ")";
    }
}
