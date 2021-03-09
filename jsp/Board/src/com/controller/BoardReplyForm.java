package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.BoardBean;
import com.service.BoardDetailProService;

/**
 * Servlet implementation class BoardReplyForm
 */
@WebServlet("/boardReplyForm")
public class BoardReplyForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardReplyForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
   		String nowPage = request.getParameter("page");
   		int board_num=Integer.parseInt(request.getParameter("board_num"));
   		BoardDetailProService boardDetailService = new BoardDetailProService();
   		try {
			BoardBean article = boardDetailService.getArticle(board_num);
			request.setAttribute("article", article);
			request.setAttribute("page", nowPage);
			RequestDispatcher rd = request.getRequestDispatcher("./board/board_reply_form.jsp");
			rd.forward(request, response);
   		} catch (Exception e) {
   			request.setAttribute("err", e.getMessage());
   			RequestDispatcher rd = request.getRequestDispatcher("./board/err.jsp");
   			rd.forward(request, response);
   		}
	}

}
