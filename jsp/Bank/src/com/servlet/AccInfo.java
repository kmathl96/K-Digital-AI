package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Account;

/**
 * Servlet implementation class AccInfo
 */
@WebServlet("/acc_info")
public class AccInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		Account acc = (Account)session.getAttribute(id);
		RequestDispatcher rd = null;
		if (acc==null) {
			rd = request.getRequestDispatcher("template.jsp?page=accsearch_fail");
		} else {
			request.setAttribute("acc",acc);
			rd = request.getRequestDispatcher("template.jsp?page=accinfo_success");
		}
		rd.forward(request, response);
	}
}