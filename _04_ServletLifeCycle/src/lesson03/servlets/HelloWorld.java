package lesson03.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloWorld implements Servlet {//servlet상속받음으로서 가져온다, 5개가 구현되어야 객체화 시킬 수 있다.
	
	ServletConfig config;// 서블릿의 정보니까 저장할 필요 

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 호출 됨");
		this.config = config;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service() 호출됨");
	}
	
	@Override
	public void destroy() {//종료
		System.out.println("destroy() 호출됨");
	}

	@Override
	public ServletConfig getServletConfig() {//부가적인 정보
		System.out.println("getServletConfig() 호출됨");
		return this.config;
	}

	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo() 호출됨");
		return "version=1.0; author=bitcamp;copyright=bitcamp 2021";
	}

}
