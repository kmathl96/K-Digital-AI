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
 * Servlet implementation class MakeAccount
 */
@WebServlet("/MakeAccount")
public class MakeAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int balance= Integer.parseInt(request.getParameter("balance"));
		String sect = request.getParameter("sect");
		String grade = request.getParameter("grade");
		Account acc = new Account();
		acc.setId(id);
		acc.setName(name);
		acc.setBalance(balance);
		acc.setSect(sect);
		acc.setGrade(grade);
		
		HttpSession session = request.getSession();
		if (session.getAttribute(id)==null) {
			session.setAttribute(id, acc);
			RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=makeaccount_success");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=makeaccount_fail");
			rd.forward(request, response);
		}
		
	}
}