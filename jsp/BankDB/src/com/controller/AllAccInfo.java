package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Account;
import com.service.AccountService;

/**
 * Servlet implementation class AllAccInfo
 */
@WebServlet("/all_acc_info")
public class AllAccInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllAccInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountService svc = new AccountService();
		try {
			ArrayList<Account> accs = svc.allAccountInfo();
			request.setAttribute("accs", accs);
			RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=allaccinfo_success");
			rd.forward(request, response);
		} catch (Exception e) {
			request.setAttribute("err", e.toString());
			RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=err");
			rd.forward(request, response);
		}
	}
}