package lesson01.sevlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
//import java.io.PrintWriter;
//
//import javax.servlet.GenericServlet;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebServlet;
//아파치에서 제공하는 라이브러리를 받아서 server상속
@SuppressWarnings("serial")//노란줄 안긋게 하기
@WebServlet("/calc")//이 주소가 갖는 이름
public class CalculatorServlet extends GenericServlet {//아파치 톰캣이 준 추상클래스 주입받을 수 있다.

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String op = req.getParameter("op");//front에서 전달
		int v1 = Integer.parseInt(req.getParameter("v1"));
		int v2 = Integer.parseInt(req.getParameter("v2"));
		int result = 0;
		
		res.setContentType("text.html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		switch(op) {
			case "+": result = v1+v2; break;
			case "-": result = v1-v2; break;
			case "*": result = v1*v2; break;
			case "/":
				if(v2==0) {
					out.println("0으로 나눌 수 없습니다");
					return;
				}
				result = v1/v2;
				break;
		}
		out.println(v1 + "" + op + " " + v2 + "=" + result);
	}

}
