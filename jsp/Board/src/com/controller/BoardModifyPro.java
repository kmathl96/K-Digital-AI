package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.BoardBean;
import com.service.BoardModifyProService;

/**
 * Servlet implementation class BoardModifyPro
 */
@WebServlet("/boardModifyPro")
public class BoardModifyPro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardModifyPro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		boolean isModifySuccess = false;
		int board_num=Integer.parseInt(request.getParameter("BOARD_NUM"));
		BoardBean article=new BoardBean();
		BoardModifyProService boardModifyProService = new BoardModifyProService();
		try {
			boolean isRightUser = boardModifyProService.isArticleWriter(board_num, request.getParameter("BOARD_PASS"));

			if (!isRightUser) {
				throw new Exception("수정할 권한이 없습니다.");
			} else {
				article.setBOARD_NUM(board_num);
				article.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
				article.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));
				isModifySuccess = boardModifyProService.modifyArticle(article);

				if (!isModifySuccess) {
					throw new Exception("수정실패");
				} else {
					response.sendRedirect("./boardDetailPro?board_num=" + article.getBOARD_NUM());
				}

			}
		} catch(Exception e) {
			request.setAttribute("err", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("./board/err.jsp");
			rd.forward(request, response);
		}
	}
}
