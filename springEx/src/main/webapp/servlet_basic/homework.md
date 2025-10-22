# day01 Servlet 과제

## 실습문제 1) HelloTimeServlet.class, index.jsp 참조

## 실습문제 2)  Calculate.html, Calculate.class 참조

---

## 개념문제 1) (OX) 서블릿 수명주기 기본 순서는 init() → service() → destroy() 이다.

**정답 : O**

- init() : 처음 한번만 수행

- service() : doGet(), doPost() 서블릿 요청 시 매번 호출

- destroy() : 서블릿 종료 요청 시 메서드 실행

## 개념문제 2) 2. `doGet`과 `doPost`의 올바른 설명은?

            A) `doGet`은 보안에 강하므로 비밀번호 전송에 권장된다          

            B) `doPost`는 본문(body)에 데이터를 담아 보낼 수 있다      

            C) `doGet`은 본문을 반드시 사용해야 한다            

            D) 둘 다 브라우저가 자동 캐시를 막는다

**정답 : B) `doPost`는 본문(body)에 데이터를 담아 보낼 수 있다**

- A) doPost 방식이 보안에 강력함

- C) doGet은 URL으로 데이터를 전달하므로 본문을 사용하지 않는다.

- D) GET 요청에 브라우저 캐시가 영향을 줄 수 있지만, POST 요청은 일반적으로 캐시되지 않는다.

## 개념문제 3) 한글 응답 본문이 깨질 때 반드시 설정해야 하는 응답 헤더(또는 API)는?

**정답 : response.setContentType("text/html; charset=UTF-8");**

## 개념문제 4) 4. 다음 중 **상태 코드**와 의미가 맞는 것은?

    A) 200 - Redirect 완료
    
    B) 302 - 임시 리다이렉트
    
    C) 404 - 서버 내부 오류
    
    D) 500 - 리소스를 찾을 수 없음

**정답 : B) 302 - 임시 리다이렉트**

- A) 200 : 정상 응답(요청 성공)

- C) 404 : Not Found(요청 리소스 찾을 수 없음)

- D) 500 : 서버 내부 오류

## 개념문제 5) 쿼리 파라미터를 읽는 메서드는?

    A) `getAttribute`  B) `getParameter`  C) `getHeader`  D) `getCookie`

**정답 : B) `getParameter`**

- A) 서버에서 request 객체에 setAttribute로 저장한 객체를 읽을 때 사용

- C) 요청 헤더 값을 읽을 때 사용

- D) 쿠키를 읽을 때 사용

## 개념문제 6) WAS 란 무엇이고 상용화 프로그램 종류2가지 

**정답 : 웹 서버로부터 오는 동적인 요청을 처리하는 서버로, 웹 로직, 아파치 톰캣 등이 있다.**

## 개념문제 7) 응답객체에 클라이언트에 전송할 데이터를 쓸 때 사용되는 클래스와 메서드는 무엇인가?

**정답 : PrintWriter(), getWriter()**

## 개념문제 8) 클라이언트가 서버에 접속했을때 WAS 부여해 주는 2가지 객체는 ?

**정답 : HttpServletRequest, HttpServletResponse** 

## 개념문제 9) 서블릿을 WAS 등록할때 사용되는 어노테이션은 무엇이고,  해당 서블릿의 이름이  myServlet 이고  my란 요청명으로  등록 방법은?

**정답 : @WebServlet(name = "myServlet", value = "/my")**

## 개념문제 10) 클라이언트가 서버에 요청시 해당 요청을 처리하는 서블릿을 연결해주는 배치관리자 역할의 파일명은 무엇이고  프로젝트에서의 위치(디렉토리명)는 어디인가?

**정답 : web.xml, webapp/WEB-INF/web.xml** 