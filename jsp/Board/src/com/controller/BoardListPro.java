package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.BoardBean;
import com.bean.PageInfo;
import com.service.BoardListProService;

/**
 * Servlet implementation class BoardListPro
 */
@WebServlet("/boardListPro")
public class BoardListPro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListPro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ArrayList<BoardBean> articleList=new ArrayList<BoardBean>();
	  	int page=1;
		int limit=10;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		try {
			BoardListProService boardListService = new BoardListProService();
			int listCount = boardListService.getListCount(); // 총 리스트 수를 받아옴.
			articleList = boardListService.getArticleList(page, limit); // 리스트를 받아옴.
			// 총 페이지 수.
			int maxPage = (int) ((double) listCount / limit + 0.95); // 0.95를 더해서 올림 처리.
			// 현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등...)
			int startPage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1;
			// 현재 페이지에 보여줄 마지막 페이지 수.(10, 20, 30 등...)
			int endPage = startPage + 10 - 1;

			if (endPage > maxPage)
				endPage = maxPage;

			PageInfo pageInfo = new PageInfo();
			pageInfo.setEndPage(endPage);
			pageInfo.setListCount(listCount);
			pageInfo.setMaxPage(maxPage);
			pageInfo.setPage(page);
			pageInfo.setStartPage(startPage);
			request.setAttribute("pageInfo", pageInfo);
			request.setAttribute("articleList", articleList);

			RequestDispatcher rd = request.getRequestDispatcher("./board/board_list_form.jsp");
			rd.forward(request, response);
		} catch(Exception e) {
			request.setAttribute("err", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("./board/err.jsp");
			rd.forward(request, response);
		}
 
	}

}
