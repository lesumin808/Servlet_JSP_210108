# Servlet_JSP_210108

### 웹 프로그램이란?
서로 연결된 상태를 네트워크

`웹프로그램이란?` 인터넷 서비스를 이용해서 서로 다른 구성요소들(PC등)이 통신할 수 있는 프로그램

<bold>프로토콜(Protocol)
- 통신을 하기위한 규약으로 HTTP(글과 텍스트가 하이퍼링크로 연결),FTP(파일 전송),SMTP(메일),POP 등..

IP주소
- 컴퓨터의 특정한 주소

port
- 컴퓨터의 프로그램 경로

> http://www.google.com:80/index.html
protocol   도메인       port  경로


### 웹 컨테이너 구조
xxx.jsp ->       (웹컨테이너(tomcat))      -> html
            jsp.java, jsp.class, jsp.obj
 
 jsp - view 
 servlet - model, control
 
 > jsp, servlet 파일 생성
 new - DinamicWeb - web.xml 생성
 
### Servlet 맵핑이란?
 Browser가 servlet을 구분하기 위한 주소를 간결하고 보안에 취약하지 않게 수정
 
 01 web.xml 맵핑 [배치 지시자(deployment descriptior)]
 - ```java <servlet-name> servletEx </servlet-name>```
 - `<url-patern> /se </url-patern>`
 
 02 java Annotation 맵핑(해당 servlet위에 작성)
 - `@WebServlet("/se")`
 
