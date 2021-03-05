package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Account;
import com.service.AccountService;

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
		AccountService svc = new AccountService();
		try {
			Account acc = svc.accountInfo(id);
			request.setAttribute("acc",acc);
			RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=accinfo_success");
			rd.forward(request, response);
		} catch (Exception e) {
			request.setAttribute("err", e.toString());
			RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=err");
			rd.forward(request, response);
		}
	}
}