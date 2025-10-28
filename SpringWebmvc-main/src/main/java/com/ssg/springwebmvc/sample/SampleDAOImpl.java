package com.ssg.springwebmvc.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository   //해당 클래스의 객체를 스프링의 빈(Bean)으로 처리한다.
@Qualifier("basic")
public class SampleDAOImpl implements SampleDAO {   //느슨한 결합
}
