package pac;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTest
 */
@WebServlet("/ServletTest")
public class ServletTest extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String param1 = request.getParameter("val1");
		String param2 = request.getParameter("val2");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		PrintWriter out = response.getWriter();
		out.write("<html><head><title>ServletTest</title></head><h1>");
		out.write(param1);
		out.write("</h1><h1>");
		out.write(param2);
//		out.write("<body><h1>현재 시간은 ");
//		out.write(Integer.toString(hour));
//		out.write("시 ");
//		out.write(Integer.toString(minute));
//		out.write("분 ");
//		out.write(Integer.toString(second));
//		out.write("초 입니다.");
		out.write("</h1></body></html>");
		out.close();
	}
	
}