package com.ssg.springwebmvc.prof;

import com.ssg.springwebmvc.sample.SampleDAO;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
@RequiredArgsConstructor
public class ClassRoom {

    private final Professor professor;
}
