package com.service;

import java.sql.Connection;

import com.bean.BoardBean;
import com.dao.BoardDAO;
import com.db.JdbcUtil;

public class BoardReplyProService {
	public boolean replyArticle(BoardBean article) throws Exception {
		boolean isReplySuccess = false;
		int insertCount = 0;
		Connection con = JdbcUtil.getConnection();
		BoardDAO boardDAO = new BoardDAO();
		insertCount = boardDAO.insertReplyArticle(article, con);

		if (insertCount > 0) {
			JdbcUtil.commit(con);
			isReplySuccess = true;
		} else {
			JdbcUtil.rollback(con);
		}

		JdbcUtil.close(con);
		return isReplySuccess;
	}
}
