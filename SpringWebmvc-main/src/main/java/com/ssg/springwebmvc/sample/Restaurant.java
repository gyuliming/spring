package com.ssg.springwebmvc.sample;


import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.aop.support.AopUtils;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Restaurant {

    private final Chef chef;
    @Override public String toString() {
        return "Restaruant(Chef=" + AopUtils.getTargetClass(chef).getName() +")";
    }
}
