package com.service;

import java.sql.Connection;

import com.bean.BoardBean;
import com.dao.BoardDAO;
import com.db.JdbcUtil;

public class BoardDetailProService {
	public BoardBean getArticle(int board_num) throws Exception {
		
		BoardBean article = null;
		Connection con = JdbcUtil.getConnection();
		BoardDAO boardDAO = new BoardDAO();
		int updateCount = boardDAO.updateReadCount(board_num, con);
		
		if(updateCount > 0){
			JdbcUtil.commit(con);
		}
		else{
			JdbcUtil.rollback(con);
		}
		
		article = boardDAO.selectArticle(board_num,con);
		JdbcUtil.close(con);
		return article;		
	}
}
