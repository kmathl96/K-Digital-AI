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
 * Servlet implementation class Withdraw
 */
@WebServlet("/withdraw")
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Withdraw() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		int money = Integer.parseInt(request.getParameter("money"));
		
		HttpSession session = request.getSession();
		Account acc = (Account)session.getAttribute(id);
		String url = "";
		if (acc==null) {
			url = "template.jsp?page=accsearch_fail";
		} else {
			boolean success = acc.withdraw(money);
			if (success) {
				url = "template.jsp?page=withdraw_success";
			} else {
				url = "template.jsp?page=withdraw_fail";
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}