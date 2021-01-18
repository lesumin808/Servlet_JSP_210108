package lesson02.get;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	
	private Hashtable<String, Operator> opTable = 
			new Hashtable<String, Operator>();
	
	public CalculatorServlet() {
		opTable.put("+", new PlusOperator());
		opTable.put("-", new MinusOperator());
		opTable.put("*", new MultipleOperator());
		opTable.put("/", new DivOperator());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get 요청");
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post 요청");
		process(req, resp);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
		// 1. 클라이언트가 보내온 변수값을 추출
		String op = req.getParameter("op");
		double v1 = Double.parseDouble(req.getParameter("v1"));
		double v2 = Double.parseDouble(req.getParameter("v2"));
		
		// 2. 우리가 보내는 데이터를 utf-8로 해석해
		resp.setContentType("text/html;charset=UTF-8");
		
		// 3. 클라이언트(브라우저)와 연결된 스트림을 포함하고 있는 연결 객체 추출
		PrintWriter out = resp.getWriter();
		
		// 4. 클라이언트(브라우저)에 데이터 전송
		out.println("<html><body>");
		out.println("<h1>계산결과</h1>");
		out.println("결과 : ");
		
		try {
			Operator operator = opTable.get(op);
			if(operator==null)
				out.println("존재하지 않는 연산자!");
			else {
				double result = operator.execute(v1, v2);
				out.println(String.format("%.3f", result));
			}				
		}catch(Exception e) {
			out.println("연산 오류 발생!");
		}
		out.println("</body></html>");
	}
}






