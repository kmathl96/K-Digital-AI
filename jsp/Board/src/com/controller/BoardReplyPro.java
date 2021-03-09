package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.BoardBean;
import com.service.BoardReplyProService;

/**
 * Servlet implementation class BoardReplyPro
 */
@WebServlet("/boardReplyPro")
public class BoardReplyPro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardReplyPro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    String nowPage = request.getParameter("page");
	 	BoardBean article = new BoardBean();  		
	 	article.setBOARD_NUM(Integer.parseInt(request.getParameter("BOARD_NUM")));
	 	article.setBOARD_NAME(request.getParameter("BOARD_NAME"));
	 	article.setBOARD_PASS(request.getParameter("BOARD_PASS"));
	 	article.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
	 	article.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));
	 	article.setBOARD_RE_REF(Integer.parseInt(request.getParameter("BOARD_RE_REF")));
	 	article.setBOARD_RE_LEV(Integer.parseInt(request.getParameter("BOARD_RE_LEV")));
	 	article.setBOARD_RE_SEQ(Integer.parseInt(request.getParameter("BOARD_RE_SEQ")));	   		
	 	BoardReplyProService boardReplyProService = new BoardReplyProService();
	 	try {
			boolean isReplySuccess = boardReplyProService.replyArticle(article);

			if (isReplySuccess) {
				response.sendRedirect("./boardListPro?page=" + nowPage);
			} else {
				throw new Exception("답장실패");
			}
		} catch (Exception e) {
			request.setAttribute("err", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("./board/err.jsp");
			rd.forward(request, response);
		}
	}
}
