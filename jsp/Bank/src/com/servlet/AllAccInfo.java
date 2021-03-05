package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Account;

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
		ArrayList<Account> accs = new ArrayList<>();
		HttpSession session = request.getSession();
		Enumeration<String> it = session.getAttributeNames();
		while (it.hasMoreElements()) {
			String name = it.nextElement();
			Object obj = session.getAttribute(name);
			if (obj instanceof Account) {
				Account acc = (Account)obj;
				accs.add(acc);
			}
		}
		RequestDispatcher rd = null;
		if (accs.size()>0) {
			request.setAttribute("accs", accs);
			rd = request.getRequestDispatcher("template.jsp?page=allaccinfo_success");
		} else {
			rd = request.getRequestDispatcher("template.jsp?page=allaccinfo_fail");
		}
		rd.forward(request, response);
	}
}