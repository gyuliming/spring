package com.ssg.webmvc1.todo.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// javax.servlet 에서 제공하는 필터, 필터를 통해서만 todo를 접근할 수 있음(직접 접근 X)
// Filter 인터페이스는 doFilter() 추상 메소드 => 필터가 필터링이 필요한 로직을 구현하는 부분
// @WebFilter 특정한 경로를 지정해서 해당 경로로 요청(request)에 대해서 doFilter()를 실행하는 구조
// LoginCheckFilter 는 /todo/* (todo의 하위에 있는 모든) 경로에 대해서 필터링을 수행
// doFilter(filterChain) 경로를 이용해서 다음 목적지로 이동하여 필터링을 시도할 수 있다.
@WebFilter(urlPatterns = {"/todo/*"})
@Log4j2
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("------------ Login doFilter ------------");

        // 캐스팅
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();

        if (session.getAttribute("loginInfo") == null) {
            response.sendRedirect("/login");
            return;
        }

        filterChain.doFilter(request, response);
    }
}
