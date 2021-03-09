package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.BoardDeleteProService;

/**
 * Servlet implementation class BoardDeletePro
 */
@WebServlet("/boardDeletePro")
public class BoardDeletePro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardDeletePro() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String nowPage = request.getParameter("page");
		BoardDeleteProService boardDeleteService = new BoardDeleteProService();

		try {
			boolean isArticleWriter = boardDeleteService.isArticleWriter(board_num, request.getParameter("BOARD_PASS"));

			if (!isArticleWriter) {
				throw new Exception("삭제할 권한이 없습니다.");
			} else {

				boolean isDeleteSuccess = boardDeleteService.removeArticle(board_num);

				if (!isDeleteSuccess) {
					throw new Exception("삭제 실패");
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("./boardListPro");
					rd.forward(request, response);
				}
			}
		} catch (Exception e) {
			request.setAttribute("err", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("./board/err.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
