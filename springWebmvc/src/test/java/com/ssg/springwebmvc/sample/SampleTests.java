package com.ssg.springwebmvc.sample;

//import lombok.RequiredArgsConstructor;
import com.ssg.springwebmvc.prof.LectureHall;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;

@Log4j2
@ExtendWith(SpringExtension.class) // Junit 버전에서 spring-test 를 이용하기 위한 설정 어노테이션
// 스프링의 설정 정보를 로딩하기 위함
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // 해당 위치에 있는 bean 들을 테스트
//@RequiredArgsConstructor
public class SampleTests {
    @Autowired // 스프링 컨테이너에 요청 (스프링에서 사용하는 의존성 주입 어노테이션)
    private SampleService sampleService; // SampleService 를 멤버 변수로 선언
    // 만일 지정된 빈이 존재한다면, 이곳에 주입

    @Autowired
    private Restaurant restaurant;

    @Autowired
    private LectureHall lectureHall;

    @Autowired
    private DataSource dataSource;

    @Test
    public void testSampleService() {
        log.info(sampleService);
        Assertions.assertNotNull(sampleService);
    }

    @Test
    public void testRestaurant() {
        log.info(restaurant);
        Assertions.assertNotNull(restaurant);
    }

    @Test
    public void testLectureHall() {
        log.info(lectureHall);
        Assertions.assertNotNull(lectureHall);
    }

    // 스프링은 필요한 객체를 스프링이 주입해주기 때문에, 개별적으로 클래스를 작성해서 빈(Bean)으로 등록해두기만 하면
    // 원하는 곳에서 쉽게 다른 객체를 사용할 수 있다.
    @Test
    public void testDataSource() throws Exception {
        Connection connection = dataSource.getConnection();
        log.info(connection);
        Assertions.assertNotNull(connection);
        connection.close();
    }
}
