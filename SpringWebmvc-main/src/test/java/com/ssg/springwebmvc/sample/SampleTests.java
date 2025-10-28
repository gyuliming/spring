package com.ssg.springwebmvc.sample;


import com.ssg.springwebmvc.prof.ClassRoom;
import com.ssg.springwebmvc.prof.Professor;
import lombok.RequiredArgsConstructor;
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
@ExtendWith(SpringExtension.class)   //Junit 버전에서 spring-test 이용하기 위한 설정 어노테이션
// 스프링의 설정 정보를 로딩하기 위한
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")


public class SampleTests {
   //스프링에서 사용하는 의존성 주입 어노테이션
    @Autowired
    private  SampleService sampleService;   //SampleService 를 멤버 변수 선언
    //만일 지정된 빈이 존재한다면 이곳에 주입해 주기를 원해요~

   @Autowired
    private Restaurant restaurant;

   @Autowired
   private ClassRoom classRoom;

   @Autowired
   private DataSource dataSource;

    @Test
    public void testSampleService() {
        log.info(sampleService);
        Assertions.assertNotNull(sampleService);
    }

    @Test
    public void testRestaruant () {
         log.info(restaurant);
         Assertions.assertNotNull(restaurant);

    }

    @Test
    public void TestClassRoom () {
        log.info(classRoom);
        Assertions.assertNotNull(classRoom);

    }
// 스프링은 필요한 객체를 스프링이 주입해 주기 때문에 개별적으로 클래스를 작성해서 빈(Bean)으로 등록해 두기만 하면 원하는 곳에서 쉽게 다른 객체를 사용할 수 있다.

    @Test
    public void TestDataSource () throws Exception {

        Connection connection = dataSource.getConnection();
        log.info(connection);
        Assertions.assertNotNull(connection);

        connection.close();

    }
}
