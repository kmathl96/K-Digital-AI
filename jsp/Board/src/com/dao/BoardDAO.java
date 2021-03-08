package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.BoardBean;
import com.db.JdbcUtil;

public class BoardDAO {
	public int insertArticle(BoardBean article, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 0;
		String sql = "";
		int insertCount = 0;
		
		try {
			pstmt = conn.prepareStatement("select max(board_num) from board");
			rs = pstmt.executeQuery();
			
			if (rs.next())
				num = rs.getInt(1)+1;
			else
				num = 1;
			JdbcUtil.close(pstmt);
			
			sql = "insert into board (BOARD_NUM, BOARD_NAME, BOARD_PASS, BOARD_SUBJECT, "
					+ "BOARD_CONTENT, BOARD_FILE, BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ, "
					+ "BOARD_READCOUNT, BOARD_DATE) values (?,?,?,?,?,?,?,?,?,?,sysdate)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, article.getBOARD_NAME());
			pstmt.setString(3, article.getBOARD_PASS());
			pstmt.setString(4, article.getBOARD_SUBJECT());
			pstmt.setString(5, article.getBOARD_CONTENT());
			pstmt.setString(6, article.getBOARD_FILE());
			pstmt.setInt(7, num);
			pstmt.setInt(8, 0);
			pstmt.setInt(9, 0);
			pstmt.setInt(10, 0);
			
			insertCount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("boardInser 에러: " + e);
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return insertCount;
	}
	//글 목록 보기.	
	public ArrayList<BoardBean> selectArticleList(int page,int limit, Connection con){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//String board_list_sql="select * from board order by BOARD_RE_REF desc,BOARD_RE_SEQ asc limit ?,10";
		String board_list_sql= "select * from ("
				+ "select row_number() over (order by BOARD_RE_REF desc,BOARD_RE_SEQ asc) num, A.* "
				+"from board A order by BOARD_RE_REF desc,BOARD_RE_SEQ asc) where num between ? and ?+10";
		
		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
		BoardBean board = null;
		int startrow=(page-1)*10+1; //읽기 시작할 row 번호..	

		try{
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, startrow);
			rs = pstmt.executeQuery();

			while(rs.next()){
				board = new BoardBean();
				board.setBOARD_NUM(rs.getInt("BOARD_NUM"));
				board.setBOARD_NAME(rs.getString("BOARD_NAME"));
				board.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
				board.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
				board.setBOARD_FILE(rs.getString("BOARD_FILE"));
				board.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
				board.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
				board.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
				board.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
				board.setBOARD_DATE(rs.getDate("BOARD_DATE"));
				articleList.add(board);
			}

		}catch(Exception ex){
			System.out.println("getBoardList 에러 : " + ex);
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return articleList;
	}
	//글의 개수 구하기.
	public int selectListCount(Connection con) {
		int listCount= 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try{
			System.out.println("getConnection");
			pstmt=con.prepareStatement("select count(*) from board");
			rs = pstmt.executeQuery();
	
			if(rs.next()){
				listCount=rs.getInt(1);
			}
		}catch(Exception ex){
			System.out.println("getListCount 에러: " + ex);			
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	
		return listCount;
	}
	
	//글 내용 보기.
	public BoardBean selectArticle(int board_num, Connection con){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardBean boardBean = null;

		try{
			pstmt = con.prepareStatement(
					"select * from board where BOARD_NUM = ?");
			pstmt.setInt(1, board_num);
			rs= pstmt.executeQuery();

			if(rs.next()){
				boardBean = new BoardBean();
				boardBean.setBOARD_NUM(rs.getInt("BOARD_NUM"));
				boardBean.setBOARD_NAME(rs.getString("BOARD_NAME"));
				boardBean.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
				boardBean.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
				boardBean.setBOARD_FILE(rs.getString("BOARD_FILE"));
				boardBean.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
				boardBean.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
				boardBean.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
				boardBean.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
				boardBean.setBOARD_DATE(rs.getDate("BOARD_DATE"));
			}
		}catch(Exception ex){
			System.out.println("getDetail 에러 : " + ex);
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return boardBean;
	}
	
	//조회수 업데이트.
		public int updateReadCount(int board_num, Connection con){
			PreparedStatement pstmt = null;
			int updateCount = 0;
			String sql="update board set BOARD_READCOUNT = "+
					"BOARD_READCOUNT+1 where BOARD_NUM = "+board_num;
			try{
				pstmt=con.prepareStatement(sql);
				updateCount = pstmt.executeUpdate();
			}catch(SQLException ex){
				System.out.println("setReadCountUpdate 에러 : "+ex);
			}
			finally{
				JdbcUtil.close(pstmt);

			}
			return updateCount;
		}

}
