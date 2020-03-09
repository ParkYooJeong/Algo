package com.spring.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.board.AmountVO;
import com.spring.biz.board.BoardVO;
import com.spring.biz.board.ProductVO;
import com.spring.biz.common.JDBCUtil;




public class AmountDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	
	private final String BOARD_INSERT = "insert into amountlist(seq, p_id,count) values((select nvl(max(seq), 0)+1 from amountlist),?,?)";
	private final String BOARD_GET = "SELECT  SUM(COUNT*P_PRICE) as sum  FROM AMOUNTLIST  LEFT OUTER JOIN PRODUCTLIST  WHERE PRODUCTLIST.P_ID=AMOUNTLIST.P_ID;";
	private final String BOARD_LIST = "select SEQ,P_NAME,COUNT, P_PRICE*COUNT AS P_PRICE from amountlist LEFT OUTER JOIN PRODUCTLIST WHERE PRODUCTLIST.P_ID=AMOUNTLIST.P_ID ";
	
	@RequestMapping(value = "/insertBoard.do")
	public void insertBoard(AmountVO vo) {
		System.out.println("===> JDBC insertBoard() ");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getP_id());
			stmt.setInt(2, vo.getCount());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public int sum() {
		System.out.println("===> JDBC 합계값 ");
		int sum=0;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			rs = stmt.executeQuery();
			while (rs.next()) {
			sum=rs.getInt("SUM");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs,stmt, conn);
		}
		return sum;
	}
	
	public List<BoardVO> getBoardList() {
		System.out.println("===> JDBC로 getBoardList() 기능 처리");
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setP_name(rs.getString("p_name"));
				board.setCount(rs.getInt("count"));
				board.setP_price(rs.getInt("P_PRICE"));
	
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return boardList;
	}
	

	
}
