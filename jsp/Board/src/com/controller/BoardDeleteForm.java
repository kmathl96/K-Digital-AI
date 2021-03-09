package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardDeleteForm
 */
@WebServlet("/boardDeleteForm")
public class BoardDeleteForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String nowPage = request.getParameter("page");
		request.setAttribute("page", nowPage);
		int board_num=Integer.parseInt(request.getParameter("board_num"));
		request.setAttribute("board_num",board_num);
		RequestDispatcher rd = request.getRequestDispatcher("./board/board_delete_form.jsp");
		rd.forward(request, response);
	}
}
