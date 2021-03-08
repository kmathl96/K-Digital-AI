package com.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.bean.BoardBean;
import com.dao.BoardDAO;
import com.db.JdbcUtil;

public class BoardListProService {
	public int getListCount() throws Exception{
		int listCount = 0;
		Connection con = JdbcUtil.getConnection();
		BoardDAO boardDAO = new BoardDAO();
		listCount = boardDAO.selectListCount(con);
		JdbcUtil.close(con);
		return listCount;
	}

	public ArrayList<BoardBean> getArticleList(int page, int limit) throws Exception{
		ArrayList<BoardBean> articleList = null;
		Connection con = JdbcUtil.getConnection();
		BoardDAO boardDAO = new BoardDAO();
		articleList = boardDAO.selectArticleList(page,limit,con);
		JdbcUtil.close(con);
		return articleList;
	}
}
