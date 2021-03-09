package com.service;

import java.sql.Connection;

import com.bean.BoardBean;
import com.dao.BoardDAO;
import com.db.JdbcUtil;

public class BoardModifyProService {
	public boolean isArticleWriter(int board_num, String pass) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isArticleWriter = false;
		Connection con = JdbcUtil.getConnection();
		BoardDAO boardDAO = new BoardDAO();
		isArticleWriter = boardDAO.isArticleBoardWriter(board_num, pass, con);
		JdbcUtil.close(con);
		return isArticleWriter;
		
	}

	public boolean modifyArticle(BoardBean article) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isModifySuccess = false;
		Connection con = JdbcUtil.getConnection();
		BoardDAO boardDAO = new BoardDAO();
		int updateCount = boardDAO.updateArticle(article, con);
		
		if(updateCount > 0){
			JdbcUtil.commit(con);
			isModifySuccess=true;
		}
		else{
			JdbcUtil.rollback(con);
		}
		
		JdbcUtil.close(con);
		return isModifySuccess;
		
	}
}
