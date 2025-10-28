package com.ssg.springwebmvc.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
//@Primary // 우선 순위로 지정
@Qualifier("event")
public class EventSampleDAOImpl implements SampleDAO {
}
