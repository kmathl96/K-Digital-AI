package com.service;

import java.sql.Connection;

import com.bean.BoardBean;
import com.dao.BoardDAO;
import com.db.JdbcUtil;

public class BoardWriteProService {
	public boolean registArticle(BoardBean boardBean) throws Exception {
		boolean isWriteSuccess = false;
		Connection conn = JdbcUtil.getConnection();
		BoardDAO boardDAO = new BoardDAO();
		int insertCount = boardDAO.insertArticle(boardBean, conn);
		
		if (insertCount > 0) {
			JdbcUtil.commit(conn);
			isWriteSuccess = true;
		} else {
			JdbcUtil.rollback(conn);
		}
		JdbcUtil.close(conn);
		return isWriteSuccess;
	}
}
