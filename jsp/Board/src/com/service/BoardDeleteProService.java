package com.service;

import java.sql.Connection;

import com.dao.BoardDAO;
import com.db.JdbcUtil;

public class BoardDeleteProService {
	public boolean isArticleWriter(int board_num, String pass) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isArticleWriter = false;
		Connection con = JdbcUtil.getConnection();
		BoardDAO boardDAO = new BoardDAO();
		isArticleWriter = boardDAO.isArticleBoardWriter(board_num, pass, con);
		JdbcUtil.close(con);
		return isArticleWriter;
	}

	public boolean removeArticle(int board_num) throws Exception{
		// TODO Auto-generated method stub
		
		boolean isRemoveSuccess = false;
		Connection con = JdbcUtil.getConnection();
		BoardDAO boardDAO = new BoardDAO();
		int deleteCount = boardDAO.deleteArticle(board_num, con);
		
		if(deleteCount > 0){
			JdbcUtil.commit(con);
			isRemoveSuccess=true;
		}
		else{
			JdbcUtil.rollback(con);
		}
		
		JdbcUtil.close(con);
		return isRemoveSuccess;
	}

}
